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

/**
 * HTTP Request methods, with the ability to decode a <code>String</code> back to its enum value.
 */
public enum Method {
	GET,
	PUT,
	POST,
	DELETE,
	HEAD,
	OPTIONS,
	TRACE,
	CONNECT,
	PATCH,
	PROPFIND,
	PROPPATCH,
	MKCOL,
	MOVE,
	COPY,
	LOCK,
	UNLOCK,
	NOTIFY,
	SUBSCRIBE;

	public static Method lookup(String method) {
		if (method == null)
			return null;

		try {
			return valueOf(method);
		} catch (IllegalArgumentException e) {
			// TODO: Log it?
			return null;
		}
	}
}
