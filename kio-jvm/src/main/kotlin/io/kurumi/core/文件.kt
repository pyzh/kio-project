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

package io.kurumi.core

import io.kurumi.jvm.*
import java.io.File

actual class 文件 : Comparable<文件> {

    lateinit var 文件: File

    @Deprecated(message = "不要使用空参构造方法", level = DeprecationLevel.ERROR)
    actual constructor()

    constructor(_文件: File) {
        文件 = _文件
    }


    actual var 名称: String = _名称
    actual var 目录: 文件 = _目录
    actual var 地址: String = _地址
    actual var 扩展名: String = _扩展名
    actual var 去扩展名: String = _去扩展名
    actual var 存在: Boolean = _存在
    actual var 是文件: Boolean = _是文件
    actual var 是目录: Boolean = _是目录
    actual var 子文件: MutableList<文件> = _子文件
    actual var 字符: String = _字符
    actual var 字节: ByteArray = _字节
    actual var 可读: Boolean = _可读
    actual var 可写: Boolean = _可写
    actual var 可执行: Boolean = _可执行
    actual var 最后修改时间: Long = _最后修改时间
    actual fun 追加(_字节: ByteArray) = _追加(_字节)
    actual fun 追加(_字符: String) = _追加(_字符)
    actual fun 子文件(_地址: String) = _子文件(_地址)
    actual fun 复制到目录(_目录: 文件) = _复制到目录(_目录)
    actual fun 复制到(_文件: 文件) = _复制到(_文件)
    actual fun 打开() = _打开()

    companion actual object {

        actual fun 可用(): Boolean = true

        actual fun 取实例(vararg _地址: String): 文件 = _取实例(*_地址)
        actual fun 取实例(_目录: 文件, vararg _地址: String): 文件 = _取实例(_目录, *_地址)

        actual val 私有目录: 文件 get() = 取实例(System.getProperty("java.tmp.dir"))

        actual fun 取私有地址(_地址: String): 文件 {
            return 取实例(私有目录, _地址)
        }

        actual fun 申请(_回调: ((_成功: Boolean) -> Unit)) {
            _回调(true)
        }


    }

    override fun compareTo(other: 文件): Int = _compareTo(other)


}