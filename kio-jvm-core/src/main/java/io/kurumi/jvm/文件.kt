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

package io.kurumi.jvm

import io.kurumi.arrString
import io.kurumi.arrayTrans
import io.kurumi.core.命令
import io.kurumi.core.文件
import io.kurumi.core.系统
import io.kurumi.data.数据
import io.kurumi.data.数据列表
import io.kurumi.synchronized
import java.io.File

private fun 文件.changeTo(file: File) {
    实例.remove(地址)
    文件 = file
    实例.put(地址, this)
}

var 文件._名称: String
    get() = 文件.name
    set(value) {
        if (value == 名称) return
        val target = File(文件.parent, value)
        if (文件.renameTo(target)) {
            changeTo(target)
        }
    }

var 文件._目录: 文件
    get() = io.kurumi.core.文件._取实例(文件.parentFile)
    set(value) {
        if (value == 目录) return
        val target = File(value.地址, 名称)
        if (文件.renameTo(target)) {
            changeTo(target)
        }
    }

var 文件._地址: String
    get() = 文件.path
    set(value) {
        val target = File(value)
        if (target == 文件) return
        if (文件.renameTo(target)) {
            changeTo(target)
        }
    }

var 文件._扩展名: String
    get() = 文件.extension
    set(value) {
        val target = File(目录.地址, 去扩展名 + value)
        if (target == 文件) return
        if (文件.renameTo(target)) {
            changeTo(target)
        }
    }

var 文件._去扩展名: String
    get() = 文件.nameWithoutExtension
    set(value) {
        val target = File(目录.地址, value + 扩展名)
        if (文件.renameTo(target)) {
            changeTo(target)
        }
    }

var 文件._存在: Boolean
    get() = 文件.exists()
    set(value) {
        if (!value) {
            文件.deleteRecursively()
        } else if (!存在) {
            文件.parentFile?.mkdirs()
            文件.createNewFile()
        }
    }

var 文件._是文件: Boolean
    get() = 文件.isFile
    set(value) {
        if (!value) {
            文件.deleteRecursively()
        } else if (!存在) {
            目录.是目录 = true
            文件.createNewFile()
        } else if (是目录) {
            文件.deleteRecursively()
            文件.createNewFile()
        }
    }

var 文件._是目录: Boolean
    get() = 文件.isDirectory
    set(value) {
        if (!value) {
            文件.deleteRecursively()
        } else if (!存在) {
            文件.mkdirs()
        } else if (是文件) {
            文件.delete()
            文件.mkdir()
        }
    }

var 文件._子文件: MutableList<文件>
    get() {
        if (!是目录) error("$地址 : 不是目录")
        val files = 文件.listFiles()
        return 数据列表(files.arrayTrans {
            io.kurumi.core.文件._取实例(this)
        }.toMutableList()).apply {
            监听器.add(object : 数据.监听器<文件> {
                override fun 添加(_内容: Collection<文件>) {
                    _内容.forEach {
                        it.目录 = this@_子文件
                    }
                }

                override fun 删除(_内容: Collection<文件>) {
                    _内容.forEach {
                        it.存在 = false
                    }
                }
            })
        }
    }
    set(value) {
        是目录 = true
        val ncl = ArrayList<文件>()
        value.forEach {
            if (it.目录 == this) ncl.add(it)
        }
        子文件.forEach {
            if (it !in ncl) {
                it.存在 = false
            }
        }
        value.forEach {
            it.目录 = this
        }
    }

var 文件._字符: String
    get() = 文件.readText()
    set(value) {
        是文件 = true
        文件.writeText(value)
    }

var 文件._字节: ByteArray
    get() = 文件.readBytes()
    set(value) {
        是文件 = true
        文件.writeBytes(value)
    }

var 文件._可读: Boolean
    get() = 文件.canRead()
    set(value) {
        文件.setReadable(value)
    }

var 文件._可写: Boolean
    get() = 文件.canWrite()
    set(value) {
        文件.setReadable(value)
    }

var 文件._可执行: Boolean
    get() = 文件.canExecute()
    set(value) {
        文件.setExecutable(value)
    }

var 文件._最后修改时间: Long
    get() = 文件.lastModified()
    set(value) {
        文件.setLastModified(value)
    }

fun 文件._追加(_字节: ByteArray) {
    文件.appendBytes(_字节)
}

fun 文件._追加(_字符: String) {
    文件.appendText(_字符)
}

fun 文件._子文件(_地址: String): 文件 {
    return io.kurumi.core.文件.取实例(this, _地址)
}

fun 文件._复制到目录(_目录: 文件): 文件 {
    if (!存在) error("文件 $地址 不存在")
    return io.kurumi.core.文件.取实例(_目录, 名称).also {
        if (是目录) {
            it.子文件 = 子文件
        } else if (是文件) {
            it.字节 = 字节
        }
    }
}

fun 文件._复制到(_文件: 文件): 文件 {
    if (!存在) error("文件 $地址 不存在")
    return _文件.also {
        if (是目录) {
            it.子文件 = 子文件
        } else if (是文件) {
            it.字节 = 字节
        }
    }
}

fun 文件._打开() {
    if (系统.Win) {
        命令.执行("start $地址")
    } else {
        命令.执行(地址)
    }
}

private val 实例 = HashMap<String, 文件>()

fun 文件.Companion._取实例(vararg _地址: String): 文件 {
    val path = _地址.arrString("/")
    实例.synchronized {
        if (实例.containsKey(path)) {
            return 实例.get(path)!!
        }
        return 文件(File(path)).apply {
            实例.put(path, this)
        }
    }
}

fun 文件.Companion._取实例(_地址: File): 文件 {
    实例.synchronized {
        if (实例.containsKey(_地址.path)) {
            return 实例.get(_地址.path)!!
        }
        return 文件(_地址).apply {
            实例.put(_地址.path, this)
        }
    }
}

fun 文件.Companion._取实例(_目录: 文件, vararg _地址: String): 文件 {
    return 取实例("${_目录.地址}/${_地址.arrString("/")}")
}

fun 文件._compareTo(other: 文件): Int {
    return if (other.文件 == 文件) 0 else -1
}