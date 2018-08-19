package io.kurumi.platform.content

interface 应用 : 上下文 {

    override val 应用: 应用 get() = this

    fun 应用启动事件()

}