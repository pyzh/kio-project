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

import cn.hutool.core.io.IoUtil
import cn.hutool.core.io.resource.FileResource
import cn.hutool.http.HttpRequest
import cn.hutool.http.HttpResponse
import cn.hutool.http.Method
import io.kurumi.data.JSON
import io.kurumi.data.JSON列表
import io.kurumi.data.数据
import io.kurumi.ifNotNull
import io.kurumi.util.异步
import java.net.InetSocketAddress
import java.net.Proxy

open actual class 连接 {

    lateinit var 请求: HttpRequest

    actual constructor(_地址: String) {
        请求 = HttpRequest(_地址)
    }

    actual constructor(_地址: String, _方法: String) : this(_地址) {
        方法 = _方法
    }

    actual var 保持连接: Boolean
        get() = 请求.isKeepAlive
        set(value) {
            请求.keepAlive(value)
        }


    actual var 地址: String
        get() = 请求.url
        set(value) {
            请求.url = value
        }

    actual var 方法: String
        get() = 请求.method.name
        set(value) {
            请求.method = Method.valueOf(value)
        }

    actual fun 请求头(_键值: String): String? {
        return 请求.header(_键值)
    }

    actual fun 请求头(_键值: String, _内容: String?, _覆盖: Boolean): 连接 {
        if (_内容 == null) 请求.removeHeader(_键值)
        else 请求.header(_键值, _内容, _覆盖)
        return this
    }

    actual fun 参数(_键值: String): String? {
        return 请求.form().get(_键值).ifNotNull {
            it?.toString()
        }
    }


    actual fun 参数(_键值: String, _内容: String?): 连接 {
        if (_内容 == null) {
            请求.form().remove(_键值)
        } else {
            请求.form().put(_键值, _内容)
        }
        return this
    }

    actual fun 文件(_键值: String): 文件? {
        return 请求.fileForm().get(_键值).ifNotNull {
            when (it) {
                is FileResource -> {
                    文件.取实例(it.file.path)
                }
                else -> null
            }
        }
    }

    actual fun 文件(_键值: String, _内容: 文件?): 连接 {
        if (_内容 == null) {
            请求.fileForm().remove(_键值)
        } else {
            请求.form(_键值, _内容.文件)
        }
        return this
    }

    actual fun 参数(_数据: 数据): 连接 {
        when (_数据.类型()) {
            数据.格式.JSON -> {
                请求.body(_数据.toString())
            }
        }
        return this
    }

    actual fun 无代理(): 连接 {
        请求.setProxy(Proxy.NO_PROXY)
        return this
    }

    actual fun HTTP代理(_地址: String, _端口: Int): 连接 {
        val addr = InetSocketAddress(_地址, _端口)
        请求.setProxy(Proxy(Proxy.Type.HTTP, addr))
        return this
    }

    actual fun SOCKS代理(_地址: String, _端口: Int): 连接 {
        val addr = InetSocketAddress(_地址, _端口)
        请求.setProxy(Proxy(Proxy.Type.SOCKS, addr))
        return this
    }

    actual fun 发送(_回调: 结果.() -> Unit) {

        异步 {

            try {

                val resp = 请求.execute()

                _回调(结果(resp))

            } catch (ex: Exception) {

                _回调(结果(null))

            }

        }

    }

    open actual inner class 结果 internal actual constructor() {

        var resp: HttpResponse? = null

        internal constructor(r: HttpResponse?) : this() {
            resp = r
        }

        actual val 成功: Boolean
            get() {
                return if (resp != null) {
                    if (状态码 >= 200 && 状态码 < 300) {
                        true
                    } else false
                } else false
            }

        actual val 状态码: Int
            get() = resp?.status ?: -1

        actual val 字节: ByteArray?
            get() = resp?.bodyBytes()

        actual val 字符: String?
            get() = resp?.body()

        actual fun 保存到(_文件: 文件) {
            val out = _文件.文件.outputStream()
            out.use { _ ->
                resp?.bodyStream()?.use { ins ->
                    IoUtil.copy(ins, out)
                }
            }
        }

        actual fun 保存到(vararg _文件: String) {
            保存到(文件.取实例(*_文件))
        }

        actual val JSON: JSON?
            get() = JSON(字符)

        actual val JSON列表: JSON列表?
            get() = JSON列表(字符)

    }

    companion actual object {

        actual fun 可用(): Boolean {
            return true
        }

    }

    actual var 格式: String
        get() = TODO()
        set(value) {}

}


