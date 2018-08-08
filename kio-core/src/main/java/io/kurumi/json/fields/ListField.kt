package io.kurumi.json.fields

import cn.hutool.json.JSONArray
import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField
import kotlin.reflect.KProperty

class ListField<List : JSONArray>(key: String,clazz : Class<List>) : JSONField<List>(key,{

    val list = it.getJSONArray(key)

    if (clazz.isInstance(list)) {
        it as List?
    }else {
        if (list == null) null
        else clazz.getConstructor(JSONArray::class.java).newInstance(list)
    }

})