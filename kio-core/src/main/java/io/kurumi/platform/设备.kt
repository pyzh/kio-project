package io.kurumi.platform

import io.kurumi.service.abs.基本服务
import io.kurumi.service.abs.界面服务
import io.kurumi.service.服务类型

object 设备 {

    internal lateinit var 实现: 设备实现

    fun 初始化实现(实现: 设备实现) {
        this.实现 = 实现;
    }

    fun 服务可用(_服务: 服务类型): Boolean = 实现.服务可用(_服务)


}

fun (() -> Unit).主线程运行() {
    val _界面: 界面服务 = 服务类型.界面.取实现()
    _界面.主线程处理(this)
}

fun <服务 : 基本服务> 服务类型.取实现(): 服务 = 设备.实现.取服务(this) as 服务