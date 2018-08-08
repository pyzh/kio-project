package io.kurumi.mcio

import io.kurumi.mcio.event.MCEvent
import io.kurumi.mcio.server.MCClient

/**
 * 事件监听器
 */
interface MCListener{

    fun onEvent(event: MCEvent)

}