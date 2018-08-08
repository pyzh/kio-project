package io.kurumi.mcio.server

import io.kurumi.mcio.MCApi
import io.kurumi.mcio.MCListener
import io.kurumi.mcio.MCPlugin
import io.kurumi.mcio.MCWSServer
import io.kurumi.mcio.cmd.CmdManager
import io.kurumi.mcio.event.MCEventManager
import org.nanohttpd.protocols.websockets.WebSocket
import java.util.*

class MCClient(val server : MCWSServer, val socket: WebSocket, val plugins: LinkedList<MCPlugin>) {

    val cmd = CmdManager(this)
    val api = MCApi(cmd)
    val eventManager = MCEventManager(this)
    val isConnnected get() = socket.isOpen
    val listeners = LinkedList<MCListener>()

}