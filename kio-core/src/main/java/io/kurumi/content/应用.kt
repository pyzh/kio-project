package io.kurumi.content

import io.kurumi.platform.设备

interface 应用 : 上下文 {

    override val 应用: 应用 get() = this

    fun 应用启动事件()

    override fun 启动界面(_界面: Class<out 界面>) {
        设备.启动界面(this, _界面)
    }

}