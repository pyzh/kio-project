package io.kurumi.mcio.event

import cn.hutool.json.JSONObject
import io.kurumi.console.info
import io.kurumi.mcio.cmd.content.CmdResult
import io.kurumi.mcio.cmd.content.MCMsg
import io.kurumi.mcio.cmd.content.MsgBody
import io.kurumi.mcio.cmd.content.header.CmdMessage
import io.kurumi.mcio.cmd.resp.prop.EventInfo
import io.kurumi.mcio.cmd.resp.prop.PlayerMessageInfo
import io.kurumi.mcio.server.MCClient

class MCEventManager(val client: MCClient) {

    val events = LinkedHashSet<EventType>()

    init {
        client.plugins.forEach {
            val ann: ListenEvent? = it::class.java.getDeclaredAnnotation(ListenEvent::class.java)
            if (ann != null) {
                events.addAll(ann.requireEvents)
            }
        }
        events.forEach {
            client.cmd.subscribe(it)
        }
    }

    fun onMessage(message: String) {

        info(message)

        val obj = JSONObject(message)

        val msg = MCMsg(obj)

        val purpose = msg.header!!.messagePurpose

        if (purpose == CmdMessage.Event) {

            onEvent(msg)

        } else if (purpose == CmdMessage.CommandResponse) {

            onCommandResponse(msg)

        }

    }

    fun onEvent(msg: MCMsg) {

        val event = MCEvent(client, msg.body!!)

        if (!events.contains(event.eventType)) {

            client.cmd.unsubscribe(event.eventType)
            return

        }

        client.listeners.forEach {

            it.onEvent(event)

        }

    }

    fun onCommandResponse(msg: MCMsg) {

        if (client.cmd.waiting.containsKey(msg.header?.requestId)) {

            val resp = client.cmd.waiting.get(msg.header!!.requestId)
            resp?.ret(CmdResult(msg.body!!))

        }

    }

    fun createInfo(body: MsgBody, type: EventType): EventInfo {

        return when (type) {
            EventType.PlayerMessage -> PlayerMessageInfo(body.properties!!)
            else -> EventInfo(body.properties!!)
        }

    }

}