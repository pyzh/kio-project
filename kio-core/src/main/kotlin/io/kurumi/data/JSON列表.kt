/*
 * Copyright 2018 MikaGuraNTK
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package io.kurumi.data

import io.kurumi.applyIfNotNull
import io.kurumi.data.JSON实现._数据
import kotlin.reflect.KClass

open class JSON列表 : 数据列表<Any>, 数据 {

    constructor() : super()
    constructor(_数据: Collection<Any>) : super(ArrayList(_数据))
    constructor(_JSON: String?) : this() {
        _JSON.applyIfNotNull {
            数据 = this
        }
    }

    var 数据: String
        get() = _数据
        set(value) {
            _数据 = value
        }

    override fun <内容 : Any> 读取(_键值: Int, _类型: KClass<内容>): 内容? {
        @Suppress("IMPLICIT_CAST_TO_ANY", "UNCHECKED_CAST")
        return when (_类型) {
            JSON::class -> 取JSON(_键值)
            else -> super.读取(_键值, _类型)
        } as 内容?
    }

    fun 取JSON(_键值: Int): JSON? {
        val value = get(_键值)
        if (value is JSON) return value
        @Suppress("UNCHECKED_CAST")
        return when (value) {
            is Map<*, *> -> JSON(value as Map<String, Any>)
            is String -> JSON(value)
            else -> null
        }.applyIfNotNull {
            set(_键值, this)
        }
    }

    fun 取JSON列表(_键值: Int): JSON列表? {
        val value = get(_键值)
        if (value is JSON列表) return value
        @Suppress("UNCHECKED_CAST")
        return when (value) {
            is Collection<*> -> JSON列表(value as Collection<Any>)
            is String -> JSON列表(value)
            else -> null
        }.applyIfNotNull {
            set(_键值, this)
        }
    }


}