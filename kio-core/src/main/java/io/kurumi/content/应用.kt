package io.kurumi.content

import io.kurumi.ui.颜色

interface 应用 : 上下文 {

    override val 应用: 应用 get() = this

    fun 应用启动事件() {}

    override fun 启动界面(_界面: Class<out 界面>) {
        应用.启动界面(_界面)
    }

}