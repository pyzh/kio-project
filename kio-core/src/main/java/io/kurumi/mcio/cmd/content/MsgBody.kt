package io.kurumi.mcio.cmd.content

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField.Companion.enumField
import io.kurumi.json.JSONField.Companion.mapField
import io.kurumi.json.fields.EnumField
import io.kurumi.json.fields.IntField
import io.kurumi.json.fields.MapField
import io.kurumi.json.fields.StringField
import io.kurumi.mcio.event.EventType

class MsgBody : JSONObject {

    constructor()
    constructor(map: JSONObject) : super(map,map.keys.toTypedArray())

    var origin by StringField("origin")
    var version by IntField("version")
    var commandLine by StringField("commandLine")
    var event by enumField<EventType>("eventName")

    val properties by mapField<JSONObject>("properties")

    init {
        version = 1
    }

}