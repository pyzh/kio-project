package io.kurumi.jvm

import io.kurumi.core.连接

var 连接.地址: String = _地址
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