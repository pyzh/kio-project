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

import org.nanohttpd.protocols.http.NanoHTTPD.ResponseException;
import org.nanohttpd.protocols.http.content.CookieHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Handles one session, i.e. parses the HTTP request and returns the response.
 */
public interface IHTTPSession {

	void execute() throws IOException;

	CookieHandler getCookies();

	Map<String, String> getHeaders();

	InputStream getInputStream();

	Method getMethod();

	/**
	 * This method will only return the first value for a given parameter. You will want to use getParameters if you
	 * expect multiple values for a given key.
	 *
	 * @deprecated use {@link #getParameters()} instead.
	 */
	@Deprecated
	Map<String, String> getParms();

	Map<String, List<String>> getParameters();

	String getQueryParameterString();

	/**
	 * @return the path part of the URL.
	 */
	String getUri();

	/**
	 * Adds the files in the request body to the files map.
	 *
	 * @param files map to modify
	 */
	void parseBody(Map<String, String> files) throws IOException, ResponseException;

	/**
	 * Get the remote ip address of the requester.
	 *
	 * @return the IP address.
	 */
	String getRemoteIpAddress();

	/**
	 * Get the remote hostname of the requester.
	 *
	 * @return the hostname.
	 */
	String getRemoteHostName();
}
