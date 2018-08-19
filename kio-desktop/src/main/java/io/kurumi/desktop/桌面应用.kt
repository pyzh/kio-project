package io.kurumi.desktop

import io.kurumi.platform.content.应用
import io.kurumi.platform.主线程运行
import io.kurumi.platform.设备

abstract class 桌面应用 {

    init {
        设备.初始化实现(桌面实现)
    }

    fun launch(args: Array<String>) {

        val ra = getAppClass().newInstance() as 应用

        { ra.应用启动事件() }.主线程运行()

    }

    abstract fun getAppClass(): Class<out 应用>

}
