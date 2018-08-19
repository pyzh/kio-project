package io.kurumi.desktop

import cn.hutool.core.util.ReflectUtil
import com.gluonhq.charm.glisten.visual.Swatch
import io.kurumi.desktop.ui.view.桌面视图
import io.kurumi.platform.content.上下文
import io.kurumi.platform.content.应用
import io.kurumi.platform.content.界面
import io.kurumi.platform.ui.view.视图
import io.kurumi.platform.ui.颜色
import javafx.scene.Scene
import javafx.stage.Screen
import javafx.stage.Stage

class 桌面界面(override val 应用: 应用) : Stage(), 界面.界面实现 {

    override var 标题: String
        get() = title
        set(value) {
            title = value
        }

    override var 内容: 视图?
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

            应用颜色(颜色.当前颜色)


        }

    val isJavaFxThemeAvailable by lazy {
        try {
            Swatch.getDefault()
            true
        } catch (ex: NoClassDefFoundError) {
            false
        }
    }

    override fun 应用颜色(_颜色: 颜色) {
        if (!isJavaFxThemeAvailable) return
        when (_颜色) {
            颜色.红色 -> Swatch.RED
            颜色.粉色 -> Swatch.PINK
            颜色.紫色 -> Swatch.PURPLE
            颜色.深紫 -> Swatch.DEEP_PURPLE
            颜色.靛蓝 -> Swatch.INDIGO
            颜色.蓝色 -> Swatch.BLUE
            颜色.亮蓝 -> Swatch.LIGHT_BLUE
            颜色.青色 -> Swatch.CYAN
            颜色.鸭绿 -> Swatch.TEAL
            颜色.绿色 -> Swatch.GREEN
            颜色.亮绿 -> Swatch.LIGHT_GREEN
            颜色.酸橙 -> Swatch.LIME
            颜色.黄色 -> Swatch.YELLOW
            颜色.琥珀 -> Swatch.AMBER
            颜色.橙色 -> Swatch.ORANGE
            颜色.暗橙 -> Swatch.DEEP_ORANGE
            颜色.棕色 -> Swatch.BROWN
            颜色.灰色 -> Swatch.GREEN
            颜色.蓝灰 -> Swatch.BLUE_GREY
            else -> null
        }?.assignTo(scene)
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