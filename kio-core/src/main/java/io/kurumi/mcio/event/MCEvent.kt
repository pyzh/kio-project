package io.kurumi.mcio.event

import io.kurumi.mcio.cmd.content.MsgBody
import io.kurumi.mcio.server.MCClient
import java.awt.Event

class MCEvent(val client : MCClient, val body: MsgBody) {

    val eventName = body.getStr("eventName")

    val eventType: EventType by lazy {
        enumValueOf<EventType>(eventName)
    }

    val info = client.eventManager.createInfo(body,eventType)

}