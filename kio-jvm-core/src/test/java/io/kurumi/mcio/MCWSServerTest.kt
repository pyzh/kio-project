package io.kurumi.mcio

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