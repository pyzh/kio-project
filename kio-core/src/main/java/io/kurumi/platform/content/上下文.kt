package io.kurumi.platform.content

import io.kurumi.platform.取实现
import io.kurumi.service.abs.界面服务
import io.kurumi.service.服务类型

interface 上下文 {

    val 应用: 应用

    fun 启动界面(_界面: Class<out 界面>) = 服务类型.界面.取实现<界面服务>().启动界面(_界面)

    fun Class<out 界面>.启动() {
        启动界面(this)
    }

}