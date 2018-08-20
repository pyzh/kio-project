package io.kurumi.net

import io.kurumi.util.提示


object RconClientTest {

    @JvmStatic
    fun main(args: Array<String>) {

        val client = RconClient("61.147.247.137", 10034, "zMDliY2U4N")

        if (client.connect()) {
            提示(client.exec("list"))
        } else {
            提示("connect failed")
        }
    }

}