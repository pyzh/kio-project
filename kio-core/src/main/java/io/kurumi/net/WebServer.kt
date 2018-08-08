package io.kurumi.net

import cn.hutool.http.Method.*
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
    open fun onWebSocketMessage(socket: WebSocket, msg : String) = Unit
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
                onWebSocketOpen(this,handshake)
            }

            override fun onClose(code: CloseCode, reason: String, initiatedByRemote: Boolean) {
                onWebSocketClose(this,code,reason)
            }

            override fun onMessage(message: WebSocketFrame) {
                onWebSocketMessage(this,message.textPayload)
            }

            override fun onPong(pong: WebSocketFrame) {
                onWebSocketPong(this,pong)
            }

            override fun onException(exception: IOException) {
                onWebSocketException(this,exception)
            }

        }

    }
}