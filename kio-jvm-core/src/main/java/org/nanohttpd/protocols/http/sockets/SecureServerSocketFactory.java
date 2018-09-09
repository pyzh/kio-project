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

package org.nanohttpd.protocols.http.sockets;

import org.nanohttpd.util.IFactoryThrowing;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;

/**
 * Creates a new SSLServerSocket
 */
public class SecureServerSocketFactory implements IFactoryThrowing<ServerSocket, IOException> {

	private SSLServerSocketFactory sslServerSocketFactory;

	private String[] sslProtocols;

	public SecureServerSocketFactory(SSLServerSocketFactory sslServerSocketFactory, String[] sslProtocols) {
		this.sslServerSocketFactory = sslServerSocketFactory;
		this.sslProtocols = sslProtocols;
	}

	@Override
	public ServerSocket create() throws IOException {
		SSLServerSocket ss = null;
		ss = (SSLServerSocket) this.sslServerSocketFactory.createServerSocket();
		if (this.sslProtocols != null) {
			ss.setEnabledProtocols(this.sslProtocols);
		} else {
			ss.setEnabledProtocols(ss.getSupportedProtocols());
		}
		ss.setUseClientMode(false);
		ss.setWantClientAuth(false);
		ss.setNeedClientAuth(false);
		return ss;
	}

}
