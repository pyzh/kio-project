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

import io.kurumi.applyIfTrue
import kotlin.reflect.KClass

open class 数据列表<内容 : Any> constructor(val 列表: MutableList<内容> = ArrayList()) : MutableList<内容> by 列表 {

    val 监听器 = ArrayList<数据.监听器<内容>>()

    override fun add(element: 内容): Boolean {
        return 列表.add(element).applyIfTrue {
            监听器.forEach {
                it.添加(listOf(element))
            }
        }
    }

    override fun add(index: Int, element: 内容) {
        列表.add(index, element)
        监听器.forEach {
            it.添加(listOf(element))
        }
    }

    override fun addAll(index: Int, elements: Collection<内容>): Boolean {
        return 列表.addAll(index, elements).applyIfTrue {
            监听器.forEach {
                it.添加(elements)
            }
        }
    }

    override fun addAll(elements: Collection<内容>): Boolean {
        return 列表.addAll(elements).applyIfTrue {
            监听器.forEach {
                it.添加(elements)
            }
        }
    }

    override fun clear() {
        监听器.forEach {
            it.删除(this)
        }
        列表.clear()
    }

    override fun remove(element: 内容): Boolean {
        return 列表.remove(element).applyIfTrue {
            监听器.forEach {
                it.删除(listOf(element))
            }
        }
    }

    override fun removeAll(elements: Collection<内容>): Boolean {
        return 列表.removeAll(elements).applyIfTrue {
            监听器.forEach {
                it.删除(elements)
            }
        }
    }

    override fun removeAt(index: Int): 内容 {
        return 列表.removeAt(index).apply {
            监听器.forEach {
                it.删除(listOf(this))
            }
        }
    }

    override fun retainAll(elements: Collection<内容>): Boolean {
        val remove = mutableListOf<内容>()
        forEach {
            if (it !in elements) {
                remove.add(it)
            }
        }
        return removeAll(remove)
    }

    override fun set(index: Int, element: 内容): 内容 {
        return 列表.set(index, element).apply {
            监听器.forEach {
                if (element == this) return@forEach
                it.添加(listOf(element))
                it.删除(listOf(this))
            }
        }
    }

    override fun subList(fromIndex: Int, toIndex: Int): MutableList<内容> {
        return 数据列表(列表.subList(fromIndex, toIndex)).apply {
            监听器.addAll(this@数据列表.监听器)
        }
    }

    inline fun <reified 内容 : Any> 读取(_键值: Int): 内容? {
        return 读取(_键值, 内容::class)
    }

    @Suppress("UNCHECKED_CAST")
    open fun <内容 : Any> 读取(_键值: Int, _类型: KClass<内容>): 内容? {
        return when (_类型) {
            Int::class -> getInt(_键值)
            Long::class -> getLong(_键值)
            Short::class -> getShort(_键值)
            Float::class -> getFloat(_键值)
            Double::class -> getDouble(_键值)
            Byte::class -> getByte(_键值)
            String::class -> getString(_键值)
            else -> opt(_键值)
        } as 内容?
    }

    open fun opt(index: Int): Any? {
        if (size <= index) return null
        return get(index)
    }

    open fun getInt(_键值: Int): Int? {
        val _内容 = opt(_键值)
        return when (_内容) {
            is Number -> _内容.toInt()
            is String -> _内容.toInt()
            else -> _内容?.toString()?.toInt()
        }
    }

    open fun getLong(_键值: Int): Long? {
        val _内容 = opt(_键值)
        return when (_内容) {
            is Number -> _内容.toLong()
            is String -> _内容.toLong()
            else -> _内容?.toString()?.toLong()
        }
    }

    open fun getShort(_键值: Int): Short? {
        val _内容 = opt(_键值)
        return when (_内容) {
            is Number -> _内容.toShort()
            is String -> _内容.toShort()
            else -> _内容?.toString()?.toShort()
        }
    }

    open fun getFloat(_键值: Int): Float? {
        val _内容 = opt(_键值)
        return when (_内容) {
            is Number -> _内容.toFloat()
            is String -> _内容.toFloat()
            else -> _内容?.toString()?.toFloat()
        }
    }

    open fun getDouble(_键值: Int): Double? {
        val _内容 = opt(_键值)
        return when (_内容) {
            is Number -> _内容.toDouble()
            is String -> _内容.toDouble()
            else -> _内容?.toString()?.toDouble()
        }
    }

    open fun getByte(_键值: Int): Byte? {
        val _内容 = opt(_键值)
        return when (_内容) {
            is Number -> _内容.toByte()
            is String -> _内容.toByte()
            else -> _内容?.toString()?.toByte()
        }
    }

    open fun getString(_键值: Int): String? {
        val _内容 = opt(_键值)
        return _内容?.toString()
    }

}