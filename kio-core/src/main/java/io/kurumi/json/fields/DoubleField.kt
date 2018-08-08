package io.kurumi.json.fields

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField
import kotlin.reflect.KProperty

class DoubleField( key : String) : JSONField<Double>(key) {
    override fun getValue(obj : JSONObject, property: KProperty<*>): Double? {
        return obj.getDouble(key)
    }
}