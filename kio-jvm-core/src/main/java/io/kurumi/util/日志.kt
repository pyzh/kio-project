package io.kurumi.util

import io.kurumi.service.实现
import io.kurumi.service.日志服务

fun 日志(log: Any?) {
    日志服务::class.实现.打印(日志服务.Level.Debug, log)
}

fun 提示(log: Any?) {
    日志服务::class.实现.打印(日志服务.Level.Info, log)
}

fun 警告(log: Any?) {
    日志服务::class.实现.打印(日志服务.Level.Warning, log)
}

fun 错误(log: Any?) {
    日志服务::class.实现.打印(日志服务.Level.Error, log)
}

