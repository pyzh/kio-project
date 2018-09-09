/*
 * Copyright 2018 MikaGuraNTK
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.nanohttpd.protocols.http;

import org.nanohttpd.protocols.http.response.Response;
import org.nanohttpd.protocols.http.response.Status;
import org.nanohttpd.protocols.http.sockets.DefaultServerSocketFactory;
import org.nanohttpd.protocols.http.sockets.SecureServerSocketFactory;
import org.nanohttpd.protocols.http.tempfiles.DefaultTempFileManagerFactory;
import org.nanohttpd.protocols.http.tempfiles.ITempFileManager;
import org.nanohttpd.protocols.http.threading.DefaultAsyncRunner;
import org.nanohttpd.protocols.http.threading.IAsyncRunner;
import org.nanohttpd.util.IFactory;
import org.nanohttpd.util.IFactoryThrowing;
import org.nanohttpd.util.IHandler;

import javax.net.ssl.*;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.security.KeyStore;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public abstract class NanoHTTPD {

	public static final String CONTENT_DISPOSITION_REGEX = "([ |\t]*Content-Disposition[ |\t]*:)(.*)";

	public static final Pattern CONTENT_DISPOSITION_PATTERN = Pattern.compile(CONTENT_DISPOSITION_REGEX,
			Pattern.CASE_INSENSITIVE);

	public static final String CONTENT_TYPE_REGEX = "([ |\t]*content-type[ |\t]*:)(.*)";

	public static final Pattern CONTENT_TYPE_PATTERN = Pattern.compile(CONTENT_TYPE_REGEX, Pattern.CASE_INSENSITIVE);

	public static final String CONTENT_DISPOSITION_ATTRIBUTE_REGEX = "[ |\t]*([a-zA-Z]*)[ |\t]*=[ |\t]*['|\"]" +
			"([^\"^']*)['|\"]";

	public static final Pattern CONTENT_DISPOSITION_ATTRIBUTE_PATTERN =
			Pattern.compile(CONTENT_DISPOSITION_ATTRIBUTE_REGEX);
	/**
	 * Maximum time to wait on Socket.getInputStream().read() (in milliseconds) This is required as the Keep-Alive HTTP
	 * connections would otherwise block the socket reading thread forever (or as long the browser is open).
	 */
	public static final int SOCKET_READ_TIMEOUT = 5000;
	/**
	 * Common MIME type for dynamic content: plain text
	 */
	public static final String MIME_PLAINTEXT = "text/plain";
	/**
	 * Common MIME type for dynamic content: html
	 */
	public static final String MIME_HTML = "text/html";
	/**
	 * logger to log to.
	 */
	public static final Logger LOG = Logger.getLogger(NanoHTTPD.class.getName());
	/**
	 * Pseudo-Parameter to use to store the actual query string in the parameters map for later re-processing.
	 */
	private static final String QUERY_STRING_PARAMETER = "NanoHttpd.QUERY_STRING";
	/**
	 * Hashtable mapping (String)FILENAME_EXTENSION -> (String)MIME_TYPE
	 */
	protected static Map<String, String> MIME_TYPES;
	public final String hostname;
	public final int myPort;
	protected List<IHandler<IHTTPSession, Response>> interceptors = new ArrayList<IHandler<IHTTPSession, Response>>(4);
	;
	/**
	 * Pluggable strategy for asynchronously executing requests.
	 */
	protected IAsyncRunner asyncRunner;
	private volatile ServerSocket myServerSocket;
	private IFactoryThrowing<ServerSocket, IOException> serverSocketFactory = new DefaultServerSocketFactory();
	private Thread myThread;
	private IHandler<IHTTPSession, Response> httpHandler;
	/**
	 * Pluggable strategy for creating and cleaning up temporary files.
	 */
	private IFactory<ITempFileManager> tempFileManagerFactory;

	/**
	 * Constructs an HTTP server on given port.
	 */
	public NanoHTTPD(int port) {
		this(null, port);
	}

	/**
	 * Constructs an HTTP server on given hostname and port.
	 */
	public NanoHTTPD(String hostname, int port) {
		this.hostname = hostname;
		this.myPort = port;
		setTempFileManagerFactory(new DefaultTempFileManagerFactory());
		setAsyncRunner(new DefaultAsyncRunner());

		// creates a default handler that redirects to deprecated serve();
		this.httpHandler = new IHandler<IHTTPSession, Response>() {

			@Override
			public Response handle(IHTTPSession input) {
				return NanoHTTPD.this.serve(input);
			}
		};
	}

	public static Map<String, String> mimeTypes() {
		if (MIME_TYPES == null) {
			MIME_TYPES = new HashMap<String, String>();
			loadMimeTypes(MIME_TYPES, "META-INF/nanohttpd/default-mimetypes.properties");
			loadMimeTypes(MIME_TYPES, "META-INF/nanohttpd/mimetypes.properties");
			if (MIME_TYPES.isEmpty()) {
				LOG.log(Level.WARNING, "no mime types found in the classpath! please provide mimetypes.properties");
			}
		}
		return MIME_TYPES;
	}

	@SuppressWarnings({
			"unchecked",
			"rawtypes"
	})
	private static void loadMimeTypes(Map<String, String> result, String resourceName) {
		try {
			Enumeration<URL> resources = NanoHTTPD.class.getClassLoader().getResources(resourceName);
			while (resources.hasMoreElements()) {
				URL url = (URL) resources.nextElement();
				Properties properties = new Properties();
				InputStream stream = null;
				try {
					stream = url.openStream();
					properties.load(stream);
				} catch (IOException e) {
					LOG.log(Level.SEVERE, "could not load mimetypes from " + url, e);
				} finally {
					safeClose(stream);
				}
				result.putAll((Map) properties);
			}
		} catch (IOException e) {
			LOG.log(Level.INFO, "no mime types available at " + resourceName);
		}
	}

	/**
	 * Creates an SSLSocketFactory for HTTPS. Pass a loaded KeyStore and an array of loaded KeyManagers. These objects
	 * must properly loaded/initialized by the caller.
	 */
	public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore loadedKeyStore, KeyManager[] keyManagers) throws IOException {
		SSLServerSocketFactory res = null;
		try {
			TrustManagerFactory trustManagerFactory =
					TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
			trustManagerFactory.init(loadedKeyStore);
			SSLContext ctx = SSLContext.getInstance("TLS");
			ctx.init(keyManagers, trustManagerFactory.getTrustManagers(), null);
			res = ctx.getServerSocketFactory();
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
		return res;
	}

	/**
	 * Creates an SSLSocketFactory for HTTPS. Pass a loaded KeyStore and a loaded KeyManagerFactory. These objects must
	 * properly loaded/initialized by the caller.
	 */
	public static SSLServerSocketFactory makeSSLSocketFactory(KeyStore loadedKeyStore,
	                                                          KeyManagerFactory loadedKeyFactory) throws IOException {
		try {
			return makeSSLSocketFactory(loadedKeyStore, loadedKeyFactory.getKeyManagers());
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
	}

	/**
	 * Creates an SSLSocketFactory for HTTPS. Pass a KeyStore resource with your certificate and passphrase
	 */
	public static SSLServerSocketFactory makeSSLSocketFactory(String keyAndTrustStoreClasspathPath, char[] passphrase) throws IOException {
		try {
			KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
			InputStream keystoreStream = NanoHTTPD.class.getResourceAsStream(keyAndTrustStoreClasspathPath);

			if (keystoreStream == null) {
				throw new IOException("Unable to load keystore from classpath: " + keyAndTrustStoreClasspathPath);
			}

			keystore.load(keystoreStream, passphrase);
			KeyManagerFactory keyManagerFactory =
					KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
			keyManagerFactory.init(keystore, passphrase);
			return makeSSLSocketFactory(keystore, keyManagerFactory);
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
	}

	/**
	 * Get MIME type from file name extension, if possible
	 *
	 * @param uri the string representing a file
	 * @return the connected mime/type
	 */
	public static String getMimeTypeForFile(String uri) {
		int dot = uri.lastIndexOf('.');
		String mime = null;
		if (dot >= 0) {
			mime = mimeTypes().get(uri.substring(dot + 1).toLowerCase());
		}
		return mime == null ? "application/octet-stream" : mime;
	}

	public static final void safeClose(Object closeable) {
		try {
			if (closeable != null) {
				if (closeable instanceof Closeable) {
					((Closeable) closeable).close();
				} else if (closeable instanceof Socket) {
					((Socket) closeable).close();
				} else if (closeable instanceof ServerSocket) {
					((ServerSocket) closeable).close();
				} else {
					throw new IllegalArgumentException("Unknown object to close");
				}
			}
		} catch (IOException e) {
			NanoHTTPD.LOG.log(Level.SEVERE, "Could not close", e);
		}
	}

	/**
	 * Decode parameters from a URL, handing the case where a single parameter name might have been supplied several
	 * times, by return lists of values. In general these lists will contain a single element.
	 *
	 * @param parms original <b>NanoHTTPD</b> parameters values, as passed to the
	 *              <code>serve()</code> method.
	 * @return a map of <code>String</code> (parameter name) to
	 * 		<code>List&lt;String&gt;</code> (a list of the values supplied).
	 */
	protected static Map<String, List<String>> decodeParameters(Map<String, String> parms) {
		return decodeParameters(parms.get(NanoHTTPD.QUERY_STRING_PARAMETER));
	}

	// -------------------------------------------------------------------------------
	// //
	//
	// Threading Strategy.
	//
	// -------------------------------------------------------------------------------
	// //

	/**
	 * Decode parameters from a URL, handing the case where a single parameter name might have been supplied several
	 * times, by return lists of values. In general these lists will contain a single element.
	 *
	 * @param queryString a query string pulled from the URL.
	 * @return a map of <code>String</code> (parameter name) to
	 * 		<code>List&lt;String&gt;</code> (a list of the values supplied).
	 */
	protected static Map<String, List<String>> decodeParameters(String queryString) {
		Map<String, List<String>> parms = new HashMap<String, List<String>>();
		if (queryString != null) {
			StringTokenizer st = new StringTokenizer(queryString, "&");
			while (st.hasMoreTokens()) {
				String e = st.nextToken();
				int sep = e.indexOf('=');
				String propertyName = sep >= 0 ? decodePercent(e.substring(0, sep)).trim() : decodePercent(e).trim();
				if (!parms.containsKey(propertyName)) {
					parms.put(propertyName, new ArrayList<String>());
				}
				String propertyValue = sep >= 0 ? decodePercent(e.substring(sep + 1)) : null;
				if (propertyValue != null) {
					parms.get(propertyName).add(propertyValue);
				}
			}
		}
		return parms;
	}

	/**
	 * Decode percent encoded <code>String</code> values.
	 *
	 * @param str the percent encoded <code>String</code>
	 * @return expanded form of the input, for example "foo%20bar" becomes "foo bar"
	 */
	public static String decodePercent(String str) {
		String decoded = null;
		try {
			decoded = URLDecoder.decode(str, "UTF8");
		} catch (UnsupportedEncodingException ignored) {
			NanoHTTPD.LOG.log(Level.WARNING, "Encoding not supported, ignored", ignored);
		}
		return decoded;
	}

	public ServerSocket getMyServerSocket() {
		return myServerSocket;
	}

	public void setHTTPHandler(IHandler<IHTTPSession, Response> handler) {
		this.httpHandler = handler;
	}

	public void addHTTPInterceptor(IHandler<IHTTPSession, Response> interceptor) {
		interceptors.add(interceptor);
	}

	/**
	 * Forcibly closes all connections that are open.
	 */
	public synchronized void closeAllConnections() {
		stop();
	}

	/**
	 * create a instance of the client handler, subclasses can return a subclass of the ClientHandler.
	 *
	 * @param finalAccept the socket the cleint is connected to
	 * @param inputStream the input stream
	 * @return the client handler
	 */
	protected ClientHandler createClientHandler(final Socket finalAccept, final InputStream inputStream) {
		return new ClientHandler(this, inputStream, finalAccept);
	}

	// -------------------------------------------------------------------------------
	// //

	/**
	 * Instantiate the server runnable, can be overwritten by subclasses to provide a subclass of the ServerRunnable.
	 *
	 * @param timeout the socet timeout to use.
	 * @return the server runnable.
	 */
	protected ServerRunnable createServerRunnable(final int timeout) {
		return new ServerRunnable(this, timeout);
	}

	public final int getListeningPort() {
		return this.myServerSocket == null ? -1 : this.myServerSocket.getLocalPort();
	}

	public final boolean isAlive() {
		return wasStarted() && !this.myServerSocket.isClosed() && this.myThread.isAlive();
	}

	public IFactoryThrowing<ServerSocket, IOException> getServerSocketFactory() {
		return serverSocketFactory;
	}

	public void setServerSocketFactory(IFactoryThrowing<ServerSocket, IOException> serverSocketFactory) {
		this.serverSocketFactory = serverSocketFactory;
	}

	public String getHostname() {
		return hostname;
	}

	public IFactory<ITempFileManager> getTempFileManagerFactory() {
		return tempFileManagerFactory;
	}

	/**
	 * Pluggable strategy for creating and cleaning up temporary files.
	 *
	 * @param tempFileManagerFactory new strategy for handling temp files.
	 */
	public void setTempFileManagerFactory(IFactory<ITempFileManager> tempFileManagerFactory) {
		this.tempFileManagerFactory = tempFileManagerFactory;
	}

	/**
	 * Call before start() to serve over HTTPS instead of HTTP
	 */
	public void makeSecure(SSLServerSocketFactory sslServerSocketFactory, String[] sslProtocols) {
		this.serverSocketFactory = new SecureServerSocketFactory(sslServerSocketFactory, sslProtocols);
	}

	/**
	 * This is the "master" method that delegates requests to handlers and makes sure there is a response to every
	 * request. You are not supposed to call or override this method in any circumstances. But no one will stop you if
	 * you do. I'm a Javadoc, not Code Police.
	 *
	 * @param session the incoming session
	 * @return a response to the incoming session
	 */
	public Response handle(IHTTPSession session) {
		for (IHandler<IHTTPSession, Response> interceptor : interceptors) {
			Response response = interceptor.handle(session);
			if (response != null)
				return response;
		}
		return httpHandler.handle(session);
	}

	/**
	 * Override this to customize the server.
	 * <p/>
	 * <p/>
	 * (By default, this returns a 404 "Not Found" plain text 错误 response.)
	 *
	 * @param session The HTTP session
	 * @return HTTP response, see class Response for details
	 */
	@Deprecated
	protected Response serve(IHTTPSession session) {
		return Response.newFixedLengthResponse(Status.NOT_FOUND, NanoHTTPD.MIME_PLAINTEXT, "Not Found");
	}

	/**
	 * Pluggable strategy for asynchronously executing requests.
	 *
	 * @param asyncRunner new strategy for handling threads.
	 */
	public void setAsyncRunner(IAsyncRunner asyncRunner) {
		this.asyncRunner = asyncRunner;
	}

	/**
	 * Start the server.
	 *
	 * @throws IOException if the socket is in use.
	 */
	public void start() throws IOException {
		start(NanoHTTPD.SOCKET_READ_TIMEOUT);
	}

	/**
	 * Starts the server (in setDaemon(true) mode).
	 */
	public void start(final int timeout) throws IOException {
		start(timeout, false);
	}

	/**
	 * Start the server.
	 *
	 * @param timeout timeout to use for socket connections.
	 * @param daemon  start the thread daemon or not.
	 * @throws IOException if the socket is in use.
	 */
	public void start(final int timeout, boolean daemon) throws IOException {
		this.myServerSocket = this.getServerSocketFactory().create();
		this.myServerSocket.setReuseAddress(true);

		ServerRunnable serverRunnable = createServerRunnable(timeout);
		this.myThread = new Thread(serverRunnable);
		this.myThread.setDaemon(daemon);
		this.myThread.setName("NanoHttpd Main Listener");
		this.myThread.start();
		while (!serverRunnable.hasBinded() && serverRunnable.getBindException() == null) {
			try {
				Thread.sleep(10L);
			} catch (Throwable e) {
				// on android this may not be allowed, that's why we
				// catch throwable the wait should be very short because we are
				// just waiting for the bind of the socket
			}
		}
		if (serverRunnable.getBindException() != null) {
			throw serverRunnable.getBindException();
		}
	}

	/**
	 * Stop the server.
	 */
	public void stop() {
		try {
			safeClose(this.myServerSocket);
			this.asyncRunner.closeAll();
			if (this.myThread != null) {
				this.myThread.join();
			}
		} catch (Exception e) {
			NanoHTTPD.LOG.log(Level.SEVERE, "Could not stop all connections", e);
		}
	}

	public final boolean wasStarted() {
		return this.myServerSocket != null && this.myThread != null;
	}

	public static final class ResponseException extends Exception {

		private static final long serialVersionUID = 6569838532917408380L;

		private final Status status;

		public ResponseException(Status status, String message) {
			super(message);
			this.status = status;
		}

		public ResponseException(Status status, String message, Exception e) {
			super(message, e);
			this.status = status;
		}

		public Status getStatus() {
			return this.status;
		}
	}
}
