package io.kurumi.json.fields

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField
import kotlin.reflect.KProperty

class LongField(key: String) : JSONField<Long>(key) {
    override fun getValue(obj: JSONObject, property: KProperty<*>): Long? {
        return obj.getLong(key)
    }
    companion object {
        fun JSONObject.longField(key: String) : LongField {
            return LongField(key)
        }
    }
}