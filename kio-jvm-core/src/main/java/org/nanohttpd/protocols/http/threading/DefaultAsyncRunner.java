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

package org.nanohttpd.protocols.http.threading;

import org.nanohttpd.protocols.http.ClientHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Default threading strategy for NanoHTTPD.
 * <p/>
 * <p>
 * By default, the server spawns a new Thread for every incoming request. These are set to <i>daemon</i> status, and
 * named according to the request number. The name is useful when profiling the application.
 * </p>
 */
public class DefaultAsyncRunner implements IAsyncRunner {

	private final List<ClientHandler> running = Collections.synchronizedList(new ArrayList<ClientHandler>());
	protected long requestCount;

	/**
	 * @return a list with currently running clients.
	 */
	public List<ClientHandler> getRunning() {
		return running;
	}

	@Override
	public void closeAll() {
		// copy of the list for concurrency
		for (ClientHandler clientHandler : new ArrayList<ClientHandler>(this.running)) {
			clientHandler.close();
		}
	}

	@Override
	public void closed(ClientHandler clientHandler) {
		this.running.remove(clientHandler);
	}

	@Override
	public void exec(ClientHandler clientHandler) {
		++this.requestCount;
		this.running.add(clientHandler);
		createThread(clientHandler).start();
	}

	protected Thread createThread(ClientHandler clientHandler) {
		Thread t = new Thread(clientHandler);
		t.setDaemon(true);
		t.setName("NanoHttpd Request Processor (#" + this.requestCount + ")");
		return t;
	}
}
