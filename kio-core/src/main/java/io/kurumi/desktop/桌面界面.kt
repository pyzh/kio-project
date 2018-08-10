package io.kurumi.desktop

import cn.hutool.core.util.ReflectUtil
import io.kurumi.content.上下文
import io.kurumi.content.应用
import io.kurumi.content.界面
import io.kurumi.desktop.ui.view.桌面视图
import io.kurumi.ui.view.视图
import javafx.scene.Scene
import javafx.stage.Screen
import javafx.stage.Stage

class 桌面界面(override val 应用: 应用) : Stage(), 界面.实现 {

    override var 标题: String
        get() = title
        set(value) {
            title = value
        }

    override var 视图: 视图?
        get() = userData as 视图?
        set(value) {

            if (value == null) error("vlaue cannot be null")

            if (value.实现 !is 桌面视图) {
                throw IllegalStateException("不支持的视图实现")
            }

            val _内容 = value.实现 as 桌面视图

            var width = 800.0
            var height = 600.0
            try {
                val bounds = Screen.getScreens()[0].bounds
                width = bounds.width / 2.5
                height = bounds.height / 1.35
            } catch (ignored: Exception) {
            }

            this.scene = Scene(_内容.内容, width, height)

        }

    override fun 关闭() {
        hide()
    }

    companion object {

        fun 启动界面(_上下文: 上下文, _界面: Class<out 界面>) {

            val _实现 = 桌面界面(_上下文.应用)

            val _实例 = ReflectUtil.newInstance(_界面)

            _实例.初始化实现(_实现)

            _实例.界面创建事件()

            _实现.show()

        }
    }


}