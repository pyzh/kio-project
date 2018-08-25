package io.kurumi.data

import io.kurumi.applyIfNotNull
import kotlin.reflect.KClass

open class JSON : 数据表, 数据 {

    constructor() : super()
    constructor(_数据: Map<String, Any>) : super(_数据)
    constructor(_JSON: String?) : this() {
        _JSON.applyIfNotNull {
            数据 = this
        }
    }

    external var 数据: String

    override fun <内容 : Any> 读取(_键值: String, _类型: KClass<内容>): 内容? {
        @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
        return when (_类型) {
            JSON::class -> 取JSON(_键值)
            else -> super.读取(_键值, _类型)
        } as 内容?
    }

    fun 取JSON(_键值: String): JSON? {
        val value = get(_键值)
        if (value is JSON) return value
        @Suppress("UNCHECKED_CAST")
        return when (value) {
            is Map<*, *> -> JSON(value as Map<String, Any>)
            is String -> JSON(value)
            else -> null
        }.applyIfNotNull {
            put(_键值, this)
        }
    }

    override fun toData(): String {
        return 数据
    }

}