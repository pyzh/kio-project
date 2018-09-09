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

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.logging.Level;

/**
 * The runnable that will be used for the main listening thread.
 */
public class ServerRunnable implements Runnable {

	private final int timeout;
	private NanoHTTPD httpd;
	private IOException bindException;

	private boolean hasBinded = false;

	public ServerRunnable(NanoHTTPD httpd, int timeout) {
		this.httpd = httpd;
		this.timeout = timeout;
	}

	@Override
	public void run() {
		try {
			httpd.getMyServerSocket().bind(httpd.hostname != null ? new InetSocketAddress(httpd.hostname,
					httpd.myPort) : new InetSocketAddress(httpd.myPort));
			hasBinded = true;
		} catch (IOException e) {
			this.bindException = e;
			return;
		}
		do {
			try {
				final Socket finalAccept = httpd.getMyServerSocket().accept();
				if (this.timeout > 0) {
					//finalAccept.setSoTimeout(this.timeout);
				}
				final InputStream inputStream = finalAccept.getInputStream();
				httpd.asyncRunner.exec(httpd.createClientHandler(finalAccept, inputStream));
			} catch (IOException e) {
				NanoHTTPD.LOG.log(Level.FINE, "Communication with the client broken", e);
			}
		} while (!httpd.getMyServerSocket().isClosed());
	}

	public IOException getBindException() {
		return bindException;
	}

	public boolean hasBinded() {
		return hasBinded;
	}
}
