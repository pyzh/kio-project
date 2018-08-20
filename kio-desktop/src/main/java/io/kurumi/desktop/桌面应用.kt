package io.kurumi.desktop

import io.kurumi.platform.content.应用
import io.kurumi.platform.设备
import io.kurumi.util.主线程
import kotlin.reflect.KClass

abstract class 桌面应用 {

    init {
        设备.初始化实现(桌面实现)
    }

    fun 启动(args: Array<String>) {

        val ra = 应用.java.newInstance() as 应用

        主线程 { ra.应用启动事件() }

    }

    abstract val 应用: KClass<out 应用>

}
