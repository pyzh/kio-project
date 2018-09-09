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

package org.nanohttpd.protocols.http.tempfiles;

import org.nanohttpd.protocols.http.NanoHTTPD;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Default strategy for creating and cleaning up temporary files.
 * <p/>
 * <p>
 * By default, files are created by <code>File.createTempFile()</code> in the directory specified.
 * </p>
 */
public class DefaultTempFile implements ITempFile {

	private final File file;

	private final OutputStream fstream;

	public DefaultTempFile(File tempdir) throws IOException {
		this.file = File.createTempFile("NanoHTTPD-", "", tempdir);
		this.fstream = new FileOutputStream(this.file);
	}

	@Override
	public void delete() throws Exception {
		NanoHTTPD.safeClose(this.fstream);
		if (!this.file.delete()) {
			throw new Exception("could not delete temporary file: " + this.file.getAbsolutePath());
		}
	}

	@Override
	public String getName() {
		return this.file.getAbsolutePath();
	}

	@Override
	public OutputStream open() throws Exception {
		return this.fstream;
	}
}
