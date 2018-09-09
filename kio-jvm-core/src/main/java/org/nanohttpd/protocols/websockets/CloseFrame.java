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

import java.nio.charset.CharacterCodingException;

public class CloseFrame extends WebSocketFrame {

	private CloseCode _closeCode;
	private String _closeReason;

	public CloseFrame(CloseCode code, String closeReason) throws CharacterCodingException {
		super(OpCode.Close, true, generatePayload(code, closeReason));
	}

	public CloseFrame(WebSocketFrame wrap) throws CharacterCodingException {
		super(wrap);
		assert wrap.getOpCode() == OpCode.Close;
		if (wrap.getBinaryPayload().length >= 2) {
			this._closeCode =
					CloseCode.find((wrap.getBinaryPayload()[0] & 0xFF) << 8 | wrap.getBinaryPayload()[1] & 0xFF);
			this._closeReason = binary2Text(getBinaryPayload(), 2, getBinaryPayload().length - 2);
		}
	}

	private static byte[] generatePayload(CloseCode code, String closeReason) throws CharacterCodingException {
		if (code != null) {
			byte[] reasonBytes = text2Binary(closeReason);
			byte[] payload = new byte[reasonBytes.length + 2];
			payload[0] = (byte) (code.getValue() >> 8 & 0xFF);
			payload[1] = (byte) (code.getValue() & 0xFF);
			System.arraycopy(reasonBytes, 0, payload, 2, reasonBytes.length);
			return payload;
		} else {
			return new byte[0];
		}
	}

	public CloseCode getCloseCode() {
		return this._closeCode;
	}

	public String getCloseReason() {
		return this._closeReason;
	}
}
