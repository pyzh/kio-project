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

package org.nanohttpd.protocols.websockets;

public enum OpCode {
	Continuation(0),
	Text(1),
	Binary(2),
	Close(8),
	Ping(9),
	Pong(10);

	private final byte code;

	private OpCode(int code) {
		this.code = (byte) code;
	}

	public static OpCode find(byte value) {
		for (OpCode opcode : values()) {
			if (opcode.getValue() == value) {
				return opcode;
			}
		}
		return null;
	}

	public byte getValue() {
		return this.code;
	}

	public boolean isControlFrame() {
		return this == Close || this == Ping || this == Pong;
	}
}
