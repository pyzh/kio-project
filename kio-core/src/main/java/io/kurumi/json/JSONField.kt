package io.kurumi.json

import cn.hutool.json.JSONArray
import cn.hutool.json.JSONObject
import io.kurumi.json.fields.BeanField
import io.kurumi.json.fields.EnumField
import io.kurumi.json.fields.ListField
import io.kurumi.json.fields.MapField
import kotlin.reflect.KProperty

abstract class JSONField<T>(val key: String,
                                  val create: (obj :JSONObject) -> T? = {obj ->
                                      obj.get(key) as T?
                                  },
                                  val setter: (value: T?) -> T? = { it }) {

    operator open fun getValue(obj: JSONObject, property: KProperty<*>): T? {
        return create(obj)
    }

    operator open fun setValue(obj: JSONObject, property: KProperty<*>, value: T?) {
        val setted = setter(value);
        if (value == null) {
            obj.remove(key)
        } else {
            obj[key] = setted as Any;
        }
    }

    companion object {

        inline fun <reified Bean> JSONObject.beanField(key: String): BeanField<Bean> {
            return BeanField(key, Bean::class.java)
        }

        inline fun <reified E : Enum<E>> JSONObject.enumField(key: String, noinline keyTrans: (key: Any?) -> String? = { key }): EnumField<E> {
            return EnumField(E::class.java, key, keyTrans)
        }

        inline fun <reified L : JSONArray> JSONObject.listField(key: String): ListField<L> {
            return ListField(key, L::class.java)
        }

        inline fun <reified M : JSONObject> JSONObject.mapField(key: String): MapField<M> {
            return MapField(key, M::class.java)
        }

    }

}