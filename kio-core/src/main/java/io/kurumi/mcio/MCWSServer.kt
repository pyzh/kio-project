package io.kurumi.mcio

import io.kurumi.mcio.server.MCClient
import io.kurumi.net.WebServer
import io.kurumi.util.提示
import io.kurumi.util.日志
import io.kurumi.util.错误
import org.nanohttpd.protocols.http.IHTTPSession
import org.nanohttpd.protocols.websockets.CloseCode
import org.nanohttpd.protocols.websockets.WebSocket
import java.io.IOException
import java.util.*

open class MCWSServer : WebServer {

    constructor(port: Int) : super(port)
    constructor(host: String, port: Int) : super(host, port)

    val clients = HashMap<WebSocket, MCClient>()
    val plugins = LinkedList<MCPlugin>()

    override fun onWebSocketOpen(socket: WebSocket, handshake: IHTTPSession) {

        提示("mc client connected from ${socket.handshakeRequest.remoteIpAddress}")

        val client = MCClient(this, socket, plugins)

        clients.put(socket, client)

        plugins.forEach {

            it.onConnected(this,client)

        }

    }

    override fun onWebSocketMessage(socket: WebSocket, msg: String) {

        日志("received event : $msg")

        clients.get(socket)?.eventManager?.onMessage(msg)
    }

    override fun onWebSocketClose(socket: WebSocket, code: CloseCode, reason: String) {

        提示("mc client desconnected because $reason")

        val client = clients.remove(socket)

        if (client != null) {
            plugins.forEach {
                it.onDisConnected(this,client)
            }
        }
    }

    override fun onWebSocketException(socket: WebSocket, ex: IOException) {

        错误("socket printError : \n$ex")

    }

}