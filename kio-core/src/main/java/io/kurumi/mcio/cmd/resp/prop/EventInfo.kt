package io.kurumi.mcio.cmd.resp.prop

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField.Companion.enumField
import io.kurumi.json.fields.BooleanField
import io.kurumi.json.fields.EnumField
import io.kurumi.json.fields.IntField
import io.kurumi.json.fields.StringField
import io.kurumi.mcio.type.GameMode

open class EventInfo : JSONObject {

    constructor(map: JSONObject) : super(map,map.keys.toTypedArray())

     val Biome by IntField("Biome")
     val Build by StringField("Build")
     val BuildPlat by StringField("BuildPlat")
     val Cheevos by BooleanField("Cheevos")
     val ClientId by StringField("ClientId")
     val Dim by IntField("Dim")
     val Dimension by IntField("Dimension")
     val Flavor by StringField("Flavor")
     val Mode by IntField("Mode")
     val MultiplayerCorrelationId by StringField("MultiplayerCorrelationId")
     val NetworkType by IntField("NetworkType")
     val Platform by StringField("Plat")
     val PlayerId by StringField("PlayerId")
     val PlayerSessionID by StringField("PlayerSessionID")
     val ServerId by StringField("ServerId")
     val UserId by StringField("UserId")
     val PlayerGameMode by enumField<GameMode>("playerGameMode", GameMode.Companion::keyTrans)
     val vrMode by BooleanField("vrMode")

}