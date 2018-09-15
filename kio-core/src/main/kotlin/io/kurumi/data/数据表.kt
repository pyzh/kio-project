/*
 * Copyright 2018 MikaGuraNTK
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.kurumi.data

import kotlin.reflect.KClass

open class 数据表(_表: Map<String, Any>? = null) : MutableMap<String, Any> by
if (_表 == null) LinkedHashMap() else LinkedHashMap(_表) {

    inline fun <reified 内容 : Any> 读取(_键值: String): 内容? {
        return 读取(_键值, 内容::class)
    }

    @Suppress("UNCHECKED_CAST")
    open fun <内容 : Any> 读取(_键值: String, _类型: KClass<内容>): 内容? {
        return when (_类型) {
            Int::class -> getInt(_键值)
            Long::class -> getLong(_键值)
            Short::class -> getShort(_键值)
            Float::class -> getFloat(_键值)
            Double::class -> getDouble(_键值)
            Byte::class -> getByte(_键值)
            String::class -> getString(_键值)
            else -> get(_键值)
        } as 内容?
    }

    open fun getInt(_键值: String): Int? {
        val _内容 = get(_键值)
        return when (_内容) {
            is Number -> _内容.toInt()
            is String -> _内容.toInt()
            else -> _内容?.toString()?.toInt()
        }
    }

    open fun getLong(_键值: String): Long? {
        val _内容 = get(_键值)
        return when (_内容) {
            is Number -> _内容.toLong()
            is String -> _内容.toLong()
            else -> _内容?.toString()?.toLong()
        }
    }

    open fun getShort(_键值: String): Short? {
        val _内容 = get(_键值)
        return when (_内容) {
            is Number -> _内容.toShort()
            is String -> _内容.toShort()
            else -> _内容?.toString()?.toShort()
        }
    }

    open fun getFloat(_键值: String): Float? {
        val _内容 = get(_键值)
        return when (_内容) {
            is Number -> _内容.toFloat()
            is String -> _内容.toFloat()
            else -> _内容?.toString()?.toFloat()
        }
    }

    open fun getDouble(_键值: String): Double? {
        val _内容 = get(_键值)
        return when (_内容) {
            is Number -> _内容.toDouble()
            is String -> _内容.toDouble()
            else -> _内容?.toString()?.toDouble()
        }
    }

    open fun getByte(_键值: String): Byte? {
        val _内容 = get(_键值)
        return when (_内容) {
            is Number -> _内容.toByte()
            is String -> _内容.toByte()
            else -> _内容?.toString()?.toByte()
        }
    }

    open fun getString(_键值: String): String? {
        val _内容 = get(_键值)
        return _内容?.toString()
    }

}