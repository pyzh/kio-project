package io.kurumi.mcio.cmd.content

import cn.hutool.json.JSONObject
import io.kurumi.json.fields.IntField
import io.kurumi.json.fields.StringField
import io.kurumi.mcio.cmd.resp.Status

class CmdResult : JSONObject {

    constructor()
    constructor(map: JSONObject) : super(map)

    val statusCode by IntField("statusCode")

    val status: Status?
        get() {
            return when (statusCode) {
                Status.Error.code -> Status.Error
                Status.Success.code -> Status.Success
                else -> null
            }
        }

    val message by StringField("message")

    val statusMessage by StringField("statusMessage")

}