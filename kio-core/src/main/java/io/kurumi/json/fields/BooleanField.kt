package io.kurumi.json.fields

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField
import kotlin.reflect.KProperty

class BooleanField(key : String) : JSONField<Boolean>(key) {
    override fun getValue(obj : JSONObject, property: KProperty<*>): Boolean? {
        return obj.getBool(key)
    }

}