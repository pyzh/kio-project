package io.kurumi.service

interface 日志服务 : 基本服务 {

    fun 打印(level: Level, log: Any?)

    enum class Level {
        Debug, Info, Warning, Error
    }

}
