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

package io.kurumi.net

import org.nanohttpd.protocols.http.IHTTPSession
import org.nanohttpd.protocols.http.response.Response
import org.nanohttpd.protocols.websockets.CloseCode
import org.nanohttpd.protocols.websockets.NanoWSD
import org.nanohttpd.protocols.websockets.WebSocket
import org.nanohttpd.protocols.websockets.WebSocketFrame
import java.io.IOException

@Suppress("DEPRECATION")
open class WebServer : NanoWSD {

    constructor(port: Int) : super(port)
    constructor(host: String, port: Int) : super(host, port)

    open fun onGet(session: IHTTPSession): Response = super.serve(session)
    open fun onPost(session: IHTTPSession): Response = super.serve(session)
    open fun onHead(session: IHTTPSession): Response = super.serve(session)
    open fun onOptions(session: IHTTPSession): Response = super.serve(session)
    open fun onPut(session: IHTTPSession): Response = super.serve(session)
    open fun onDelete(session: IHTTPSession): Response = super.serve(session)
    open fun onTrace(session: IHTTPSession): Response = super.serve(session)
    open fun onConnect(session: IHTTPSession): Response = super.serve(session)
    open fun onPatch(session: IHTTPSession): Response = super.serve(session)

    open fun onWebSocketOpen(socket: WebSocket, handshake: IHTTPSession) = Unit
    open fun onWebSocketMessage(socket: WebSocket, msg: String) = Unit
    open fun onWebSocketClose(socket: WebSocket, code: CloseCode, reason: String) = Unit
    open fun onWebSocketPong(socket: WebSocket, pong: WebSocketFrame) = Unit
    open fun onWebSocketException(socket: WebSocket, ex: IOException) = Unit

    @Suppress("DEPRECATION")
    override fun serve(session: IHTTPSession): Response {

        return when (session.method) {

            GET -> onGet(session)
            POST -> onPost(session)
            HEAD -> onHead(session)
            OPTIONS -> onOptions(session)
            PUT -> onPut(session)
            DELETE -> onDelete(session)
            TRACE -> onTrace(session)
            CONNECT -> onConnect(session)
            PATCH -> onPatch(session)
            else -> super.serve(session)

        }

    }

    override final fun openWebSocket(handshake: IHTTPSession): WebSocket {

        return object : WebSocket(handshake) {

            override fun onOpen() {
                onWebSocketOpen(this, handshake)
            }

            override fun onClose(code: CloseCode, reason: String, initiatedByRemote: Boolean) {
                onWebSocketClose(this, code, reason)
            }

            override fun onMessage(message: WebSocketFrame) {
                onWebSocketMessage(this, message.textPayload)
            }

            override fun onPong(pong: WebSocketFrame) {
                onWebSocketPong(this, pong)
            }

            override fun onException(exception: IOException) {
                onWebSocketException(this, exception)
            }

        }

    }
}