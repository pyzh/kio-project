package io.kurumi.mcio

import io.kurumi.mcio.event.EventType
import io.kurumi.mcio.event.ListenEvent
import io.kurumi.mcio.server.MCClient

object MCWSServerTest : MCWSServer("0.0.0.0", 3390) {

    @JvmStatic
    fun main(args: Array<String>) {

        plugins.add(TestPlugin)

        start()

    }

    @ListenEvent(EventType.PlayerMessage)
    object TestPlugin : MCPlugin {

        override fun onDisConnected(server: MCWSServer, client: MCClient) {

        }

        override fun onConnected(server: MCWSServer, client: MCClient) {
            client.api.say("[huaq]")
        }

    }

}