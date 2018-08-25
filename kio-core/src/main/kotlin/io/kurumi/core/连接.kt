package io.kurumi.core

import io.kurumi.append
import io.kurumi.data.数据

class 连接(_地址: String, _方法: String = "GET") {

    private val 实现 = 连接实现(this)

    var 地址: String = _地址
        get() {
            if (方法 == "GET" && 参数.isNotEmpty()) {
                val url = StringBuilder(field)
                var first = true
                参数.forEach {
                    url.append(if (first) {
                        first = false;"?"
                    } else "&")
                    url.append("${it.key}=${it.value}")
                }
                return url.toString()
            } else {
                return field
            }
        }
        set(value) {
            field = if (value.contains("?")) {
                value.replace("\\?.*", "")
            } else value
        }

    var 方法: String = _方法
        set(value) {
            field = value.toUpperCase()
        }

    var 请求头 = HashMap<String, String>()

    fun 请求头(_键值: String): String? {
        return 请求头.get(_键值)
    }

    fun 请求头(_键值: String, _内容: String?): 连接 {
        if (_内容 == null) {
            请求头.remove(_键值)
        } else {
            请求头.put(_键值, if (_键值 == "Content-Type") _内容.append(";boundary=$标识") else _内容)
        }
        return this
    }

    var 标识: String = "kurumi"

    internal var 参数 = LinkedHashMap<String, String>()
    internal var 文件 = LinkedHashMap<String, 文件>()

    var 内容: String? = null

    fun 参数(_键值: String): String? {
        return 参数.get(_键值)
    }

    fun 参数(_键值: String, _内容: String?): 连接 {
        if (_内容 == null) {
            参数.remove(_键值)
        } else {
            if (文件.containsKey(_键值)) 文件(_键值, null)
            参数.put(_键值, _内容)
        }
        return this
    }

    fun 文件(_键值: String): String? {
        return 参数.get(_键值)
    }

    fun 文件(_键值: String, _内容: 文件?): 连接 {
        if (_内容 == null) {
            文件.remove(_键值)
        } else {
            if (参数.containsKey(_键值)) 参数(_键值, null)
            文件.put(_键值, _内容)
        }
        return this
    }

    fun 参数(_数据: 数据) {
        内容 = _数据.toString()
    }

    /*
    var 内容: ByteArray? = null
        get() {
            return if (方法 !in arrayOf("GET","HEAD")) {
                if (格式 == 格式_表单) {
                    val fd = StringBuilder()

                    val _分隔 = "--$标识"
                    val _换行 = "\r\n"

                    参数.forEach {
                        fd.append(_换行)
                        fd.append(_分隔)
                        fd.append(_换行)
                        fd.append("Content-Disposition: form-data;name=${编码.链接.编码(it.key)}")
                        fd.append(_换行)
                        fd.append(编码.链接.编码(it.value))
                    }

                    fd.toString().toByteArray()
                } else if (格式 == 格式_JSON) {
                    val json = JSON(String.fromByteArray(field))
                    json.putAll(参数)
                    json.toString().toByteArray()
                } else field
            } else null
        }

*/

    var 格式: String = 格式_表单
        set(value) {
            field = value
            请求头("Content-Type", value)
        }

    val 格式_表单 get() = "multipart/form-data"
    val 格式_JSON get() = "application/json"

    fun 发送(_回调: (结果) -> Unit) {}

    open inner class 结果 {

        private val 实现 = 结果实现(this)

        val 成功: Boolean
            get() = 实现.成功

        val 状态码: Int

        val Cookie: MutableMap<String, String>

        val 字节: ByteArray
        val 字符: String

        fun 保存(_地址: String)

    }

    companion object {
        val HTTP_1 = "HTTP/1.0"
        val HTTP_1_1 = "HTTP/1.1"
        val HTTP_2 = "HTTP/2.0"
        external fun 可用(): Boolean
    }

    init {
        实现.初始化()
    }

}

expect internal class 连接实现 constructor(_连接: 连接) {

    fun 初始化()

}

expect internal class 结果实现 constructor(_结果: 连接.结果) {

    val 成功: Boolean
    val 状态码: Int

    val Cookie: MutableMap<String, String>

    val 字节: ByteArray
    val 字符: String

    fun 保存(_地址: String)

}