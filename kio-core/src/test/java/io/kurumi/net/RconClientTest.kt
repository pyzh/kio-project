package io.kurumi.net

import io.kurumi.console.printInfo
import io.kurumi.net.RconClient


object RconClientTest {

    @JvmStatic
    fun main(args: Array<String>) {

        val client = RconClient("61.147.247.137", 10034, "zMDliY2U4N")

        if (client.connect()) {
            printInfo(client.exec("list"))
        } else {
            printInfo("connect failed")
        }
    }

}