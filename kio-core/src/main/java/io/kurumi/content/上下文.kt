package io.kurumi.content

interface 上下文 {

    val 应用: 应用

    fun 启动界面(_界面: Class<out 界面>) = 应用.启动界面(_界面)

    fun Class<out 界面>.启动() {
        启动界面(this)
    }

}