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

package io.kurumi.core

import io.kurumi.data.JSON
import io.kurumi.data.JSON列表
import io.kurumi.data.数据

expect class 连接 {

    constructor(_地址: String)
    constructor(_地址: String, _方法: String)

    var 保持连接: Boolean
    var 地址: String
    var 方法: String

    fun 请求头(_键值: String): String?
    fun 请求头(_键值: String, _内容: String?, _覆盖: Boolean = true): 连接

    fun 参数(_键值: String): String?
    fun 参数(_键值: String, _内容: String?): 连接
    fun 文件(_键值: String): 文件?
    fun 文件(_键值: String, _内容: 文件?): 连接
    fun 参数(_数据: 数据): 连接

    fun 无代理(): 连接
    fun HTTP代理(_地址: String, _端口: Int = 80): 连接
    fun SOCKS代理(_地址: String, _端口: Int): 连接

    fun 发送(_回调: 结果.() -> Unit)

    open inner class 结果 internal constructor() {

        val 成功: Boolean

        val 状态码: Int

        val 字节: ByteArray?
        val 字符: String?
        val JSON: JSON?
        val JSON列表: JSON列表?

        fun 保存到(_文件: 文件)
        fun 保存到(vararg _文件: String)

    }

    companion object {
        fun 可用(): Boolean
    }

}