package io.kurumi.service

import io.kurumi.platform.设备
import kotlin.reflect.KClass

interface 基本服务 {
}

val <服务 : 基本服务> KClass<服务>.实现: 服务
    get() {
        if (!设备.服务可用(this)) {
            error("服务 : ${java.simpleName} 不可用")
        }
        return 设备.取服务(this)
    }