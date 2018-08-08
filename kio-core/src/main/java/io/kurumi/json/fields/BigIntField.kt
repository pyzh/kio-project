package io.kurumi.json.fields

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField
import java.math.BigInteger
import kotlin.reflect.KProperty

class BigIntField(key: String) : JSONField<BigInteger>(key) {
    override fun getValue(obj: JSONObject, property: KProperty<*>): BigInteger? {
        return obj.getBigInteger(key)
    }
}