package io.kurumi.core

import io.kurumi.jvm._执行

actual object 命令 {

    actual fun 可用(): Boolean {
        return true
    }

    actual fun 执行(vararg _命令: String, _回调: (_成功: Boolean, _结果: String) -> Unit) {
        _执行(_命令, _回调)
    }


}