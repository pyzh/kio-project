package io.kurumi.json.fields

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField
import kotlin.reflect.KProperty

class IntField( key: String) : JSONField<Int>(key) {
    override fun getValue(obj: JSONObject, property: KProperty<*>): Int? {
        return obj.getInt(key)
    }
}