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

package org.nanohttpd.protocols.http.content;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * A simple cookie representation. This is old code and is flawed in many ways.
 *
 * @author LordFokas
 */
public class Cookie {

	private final String n, v, e;

	public Cookie(String name, String value) {
		this(name, value, 30);
	}

	public Cookie(String name, String value, int numDays) {
		this.n = name;
		this.v = value;
		this.e = getHTTPTime(numDays);
	}

	public Cookie(String name, String value, String expires) {
		this.n = name;
		this.v = value;
		this.e = expires;
	}

	public static String getHTTPTime(int days) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		calendar.add(Calendar.DAY_OF_MONTH, days);
		return dateFormat.format(calendar.getTime());
	}

	public String getHTTPHeader() {
		String fmt = "%s=%s; expires=%s";
		return String.format(fmt, this.n, this.v, this.e);
	}
}
