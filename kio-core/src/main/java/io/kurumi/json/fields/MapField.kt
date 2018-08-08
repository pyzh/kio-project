package io.kurumi.json.fields

import cn.hutool.json.JSONObject
import io.kurumi.json.JSONField

class MapField<Map : JSONObject>(key: String, val clazz: Class<Map>) : JSONField<Map>(key, { obj ->

    val map = obj.getJSONObject(key)

    if (clazz.isInstance(map)) {
        map as Map?
    } else {
        if (map == null) null
        else clazz.getConstructor(JSONObject::class.java).newInstance(map)
    }

})