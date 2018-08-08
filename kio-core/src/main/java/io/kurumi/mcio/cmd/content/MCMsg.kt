package io.kurumi.mcio.cmd.content

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField.Companion.mapField
import io.kurumi.json.fields.MapField

class MCMsg : JSONObject {

    constructor()
    constructor(map : JSONObject) : super(map)

    var header by mapField<MsgHeader>("header")
    var body by mapField<MsgBody>("body")



}