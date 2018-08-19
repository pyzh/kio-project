package io.kurumi.net

import io.kurumi.util.info


object RconClientTest {

    @JvmStatic
    fun main(args: Array<String>) {

        val client = RconClient("61.147.247.137", 10034, "zMDliY2U4N")

        if (client.connect()) {
            info(client.exec("list"))
        } else {
            info("connect failed")
        }
    }

}