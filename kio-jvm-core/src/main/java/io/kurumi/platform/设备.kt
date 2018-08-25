package io.kurumi.platform

import io.kurumi.service.基本服务
import kotlin.reflect.KClass

object 设备 {

    internal lateinit var 实现: 设备实现

    fun 初始化实现(实现: 设备实现) {
        this.实现 = 实现;
    }

    fun <服务 : 基本服务> 服务可用(_服务: KClass<服务>): Boolean = 实现.服务可用(_服务)
    fun <服务 : 基本服务> 取服务(_服务: KClass<服务>): 服务 = 实现.取服务(_服务) as 服务


}