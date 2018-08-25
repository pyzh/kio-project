package io.kurumi.jvm

import io.kurumi.arrString
import io.kurumi.core.命令

fun 命令._执行(_命令: Array<out String>, _回调: (_成功: Boolean, _结果: String) -> Unit) {
    try {
        val _进程 = Runtime.getRuntime().exec(_命令.arrString(" "))
        _回调(_进程.exitValue() == 0, String(_进程.errorStream.readBytes()))
    } catch (ex: Exception) {
        _回调(false, ex.toString())
    }
}