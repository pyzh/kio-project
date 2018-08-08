package io.kurumi.json.fields

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField
import kotlin.reflect.KProperty

class StringField(key :String) : JSONField<String>(key) {
    override fun getValue(obj: JSONObject, property: KProperty<*>): String? {
        return obj.getStr(key)
    }
}