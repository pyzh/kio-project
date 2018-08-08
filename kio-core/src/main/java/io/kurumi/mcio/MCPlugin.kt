package io.kurumi.mcio

import io.kurumi.mcio.server.MCClient

interface MCPlugin {

    fun onConnected(server : MCWSServer, client : MCClient)

    fun onDisConnected(server : MCWSServer, client : MCClient)

}
