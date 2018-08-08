package io.kurumi.mcio.cmd.resp.prop

import cn.hutool.json.JSONObject
import io.kurumi.json.fields.StringField

class PlayerMessageInfo : EventInfo {

    constructor(map: JSONObject) : super(map)

    val sender by StringField("Sender")
    val message by StringField("Message")
    val messageType by StringField("MessageType")

}