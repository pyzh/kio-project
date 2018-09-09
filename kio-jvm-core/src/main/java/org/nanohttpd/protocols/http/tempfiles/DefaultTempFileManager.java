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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * Default strategy for creating and cleaning up temporary files.
 * <p/>
 * <p>
 * This class stores its files in the standard location (that is, wherever
 * <code>java.io.tmpdir</code> points to). Files are added to an internal list,
 * and deleted when no longer needed (that is, when <code>clear()</code> is invoked at the end of processing a
 * request).
 * </p>
 */
public class DefaultTempFileManager implements ITempFileManager {

	private final File tmpdir;

	private final List<ITempFile> tempFiles;

	public DefaultTempFileManager() {
		this.tmpdir = new File(System.getProperty("java.io.tmpdir"));
		if (!tmpdir.exists()) {
			tmpdir.mkdirs();
		}
		this.tempFiles = new ArrayList<ITempFile>();
	}

	@Override
	public void clear() {
		for (ITempFile file : this.tempFiles) {
			try {
				file.delete();
			} catch (Exception ignored) {
				NanoHTTPD.LOG.log(Level.WARNING, "could not delete file ", ignored);
			}
		}
		this.tempFiles.clear();
	}

	@Override
	public ITempFile createTempFile(String filename_hint) throws Exception {
		DefaultTempFile tempFile = new DefaultTempFile(this.tmpdir);
		this.tempFiles.add(tempFile);
		return tempFile;
	}
}
