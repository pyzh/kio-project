package io.kurumi.json.fields

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField
import kotlin.reflect.KProperty

class BeanField<T>(key: String, val clazz: Class<T>) : JSONField<T>(key) {
    override fun getValue(obj: JSONObject, property: KProperty<*>): T? {
        return obj.getBean(key, clazz)
    }
}