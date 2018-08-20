package io.kurumi.desktop

import io.kurumi.platform.content.应用
import kotlin.reflect.KClass

object 桌面应用测试 : 桌面应用() {

    @JvmStatic
    fun main(args: Array<String>) {
        启动(args)
    }

    override val 应用: KClass<out 应用> get() = App::class

    class App : 应用 {

        override fun 应用启动事件() {

            测试界面::class.启动()

        }

    }


}
