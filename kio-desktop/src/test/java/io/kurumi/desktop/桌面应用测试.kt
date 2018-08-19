package io.kurumi.desktop

import io.kurumi.platform.content.应用

object 桌面应用测试 : 桌面应用() {

    @JvmStatic
    fun main(args: Array<String>) {
        launch(args)
    }

    override fun getAppClass(): Class<out 应用> {
        return App::class.java
    }

    class App : 应用 {

        override fun 应用启动事件() {

            测试界面::class.java.启动()

        }

    }


}
