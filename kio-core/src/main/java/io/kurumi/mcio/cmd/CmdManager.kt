package io.kurumi.mcio.cmd

import io.kurumi.console.debug
import io.kurumi.mcio.cmd.content.MCMsg
import io.kurumi.mcio.cmd.content.MsgBody
import io.kurumi.mcio.cmd.content.MsgHeader
import io.kurumi.mcio.cmd.content.header.CmdMessage
import io.kurumi.mcio.event.EventType
import io.kurumi.mcio.server.MCClient
import io.kurumi.mcio.type.Entry
import java.util.*
import kotlin.collections.LinkedHashMap

class CmdManager(val client: MCClient) {

    val waiting = LinkedHashMap<String, CmdResp>()

    fun send(command: String, vararg params: Any?): CmdResp {

        var rawcmd = command

        var size = 0

        params.forEach {

            if (it != null) {

                rawcmd += " $it"

            }

        }

        val cmd = MCMsg()

        val id = UUID.randomUUID().toString()

        cmd.header = MsgHeader()

        cmd.header?.requestId = id;
        cmd.header?.messagePurpose = CmdMessage.CommandRequest
        cmd.header?.messageType = CmdMessage.CommandRequest

        cmd.body = MsgBody()
        cmd.body?.origin = Entry.player;
        cmd.body?.commandLine = rawcmd;

        val json = "$cmd"

        debug("sended : $json")

        client.socket.send(json)

        val result = CmdResp(this, id)

        return result

    }

    fun subscribe(event: EventType) {

        val cmd = MCMsg()

        val id = UUID(0, 0).toString()

        cmd.header = MsgHeader()

        cmd.header?.requestId = id;
        cmd.header?.messagePurpose = CmdMessage.Subscribe
        cmd.header?.messageType = CmdMessage.CommandRequest

        cmd.body = MsgBody()
        cmd.body?.event = event

        val json = "$cmd"

        debug("event subscribed : ${event}")

        client.socket.send(json)

    }

    fun unsubscribe(event: EventType) {

        val cmd = MCMsg()

        val id = UUID(0, 0).toString()

        cmd.header = MsgHeader()

        cmd.header?.requestId = id;
        cmd.header?.messagePurpose = CmdMessage.UnSubscribe
        cmd.header?.messageType = CmdMessage.CommandRequest

        cmd.body = MsgBody()
        cmd.body?.event = event

        val json = "$cmd"

        debug("event unsubscribed : ${event}")

        client.socket.send(json)

    }

}