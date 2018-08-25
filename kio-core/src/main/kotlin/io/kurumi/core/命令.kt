package io.kurumi.core

expect object 命令 {

    fun 可用(): Boolean
    fun 执行(vararg _命令: String, _回调: (_成功: Boolean, _结果: String) -> Unit = { _成功, _结果 -> })

}