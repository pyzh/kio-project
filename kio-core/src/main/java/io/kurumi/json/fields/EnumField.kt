package io.kurumi.json.fields

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField
import kotlin.reflect.KProperty

class EnumField<E : Enum<E>>(val clazz: Class<E>, key: String, val keyTrans: (key: Any?) -> String? = { key }) : JSONField<E>(key) {

    override fun getValue(obj: JSONObject, property: KProperty<*>): E? {
        val k = obj.get(key)
        return obj.getEnum(clazz, keyTrans(k))
    }

}