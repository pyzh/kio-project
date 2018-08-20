package io.kurumi.desktop.service

import io.kurumi.service.日志服务
import java.util.*

object 桌面日志服务 : 日志服务 {

    @Suppress("DEPRECATION")
    override fun 打印(level: 日志服务.Level, log: Any?) {
        when (level) {
            日志服务.Level.Warning, 日志服务.Level.Error -> System.err.println("[Kurumi][${Date().toLocaleString()}]{log?.toString() ?: null}")
            else -> println(log?.toString() ?: "null")
        }
    }

}