package io.kurumi.platform.content

import io.kurumi.service.实现
import io.kurumi.service.界面服务
import kotlin.reflect.KClass

interface 上下文 {

    val 应用: 应用

    fun 启动界面(_界面: Class<out 界面>) = 界面服务::class.实现.启动界面(this, _界面)

    fun KClass<out 界面>.启动() {
        启动界面(java)
    }

}