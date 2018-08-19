package io.kurumi.mcio

import io.kurumi.mcio.server.MCClient
import io.kurumi.net.WebServer
import io.kurumi.util.debug
import io.kurumi.util.err
import io.kurumi.util.info
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

        info("mc client connected from ${socket.handshakeRequest.remoteIpAddress}")

        val client = MCClient(this, socket, plugins)

        clients.put(socket, client)

        plugins.forEach {

            it.onConnected(this,client)

        }

    }

    override fun onWebSocketMessage(socket: WebSocket, msg: String) {

        debug("received event : $msg")

        clients.get(socket)?.eventManager?.onMessage(msg)
    }

    override fun onWebSocketClose(socket: WebSocket, code: CloseCode, reason: String) {

        info("mc client desconnected because $reason")

        val client = clients.remove(socket)

        if (client != null) {
            plugins.forEach {
                it.onDisConnected(this,client)
            }
        }
    }

    override fun onWebSocketException(socket: WebSocket, ex: IOException) {

        err("socket printError : \n$ex")

    }

}