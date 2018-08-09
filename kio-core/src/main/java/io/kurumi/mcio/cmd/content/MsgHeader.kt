package io.kurumi.mcio.cmd.content

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField.Companion.enumField
import io.kurumi.json.fields.EnumField
import io.kurumi.json.fields.IntField
import io.kurumi.json.fields.StringField
import io.kurumi.mcio.cmd.content.header.CmdMessage

class MsgHeader : JSONObject {

    constructor()
    constructor(map : JSONObject) : super(map)

    var requestId by StringField("requestId")
    var messagePurpose by enumField<CmdMessage>("messagePurpose") { CmdMessage.keyTrans(it?.toString() ?: "")}
    var messageType  by enumField<CmdMessage>("messageType") { CmdMessage.keyTrans(it?.toString() ?: "")}
    var version by IntField("version")

    init {
        version = 1
    }

}