package io.kurumi.platform

import io.kurumi.service.基本服务
import kotlin.reflect.KClass

open class 设备实现 {

    private val 所有服务 = HashMap<KClass<out 基本服务>, 基本服务>()

    fun 服务可用(_服务: KClass<out 基本服务>): Boolean {
        return 所有服务.containsKey(_服务)
    }

    fun 取服务(_服务: KClass<out 基本服务>): 基本服务? {
        return 所有服务.get(_服务)
    }

    fun <服务 : 基本服务> 注册服务(_服务: KClass<服务>, _实现: 服务) {
        所有服务.put(_服务, _实现)
    }

}