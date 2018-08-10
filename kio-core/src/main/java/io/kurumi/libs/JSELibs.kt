package io.kurumi.libs

import com.gluonhq.charm.glisten.visual.Swatch
import io.kurumi.ui.颜色
import io.kurumi.ui.颜色.Companion.亮绿
import io.kurumi.ui.颜色.Companion.亮蓝
import io.kurumi.ui.颜色.Companion.暗橙
import io.kurumi.ui.颜色.Companion.棕色
import io.kurumi.ui.颜色.Companion.橙色
import io.kurumi.ui.颜色.Companion.深紫
import io.kurumi.ui.颜色.Companion.灰色
import io.kurumi.ui.颜色.Companion.琥珀
import io.kurumi.ui.颜色.Companion.粉色
import io.kurumi.ui.颜色.Companion.紫色
import io.kurumi.ui.颜色.Companion.红色
import io.kurumi.ui.颜色.Companion.绿色
import io.kurumi.ui.颜色.Companion.蓝灰
import io.kurumi.ui.颜色.Companion.蓝色
import io.kurumi.ui.颜色.Companion.酸橙
import io.kurumi.ui.颜色.Companion.青色
import io.kurumi.ui.颜色.Companion.靛蓝
import io.kurumi.ui.颜色.Companion.鸭绿
import io.kurumi.ui.颜色.Companion.黄色
import javafx.scene.Scene

object JSELibs {

    val isJavaFxThemeAvailable by lazy {
        try {
            Swatch.getDefault()
            true
        } catch (ex: NoClassDefFoundError) {
            false
        }
    }

    fun applyJavaFxTheme(scene: Scene, color: 颜色) {

        if (!isJavaFxThemeAvailable) return

        when (color) {
            红色 -> Swatch.RED
            粉色 -> Swatch.PINK
            紫色 -> Swatch.PURPLE
            深紫 -> Swatch.DEEP_PURPLE
            靛蓝 -> Swatch.INDIGO
            蓝色 -> Swatch.BLUE
            亮蓝 -> Swatch.LIGHT_BLUE
            青色 -> Swatch.CYAN
            鸭绿 -> Swatch.TEAL
            绿色 -> Swatch.GREEN
            亮绿 -> Swatch.LIGHT_GREEN
            酸橙 -> Swatch.LIME
            黄色 -> Swatch.YELLOW
            琥珀 -> Swatch.AMBER
            橙色 -> Swatch.ORANGE
            暗橙 -> Swatch.DEEP_ORANGE
            棕色 -> Swatch.BROWN
            灰色 -> Swatch.GREEN
            蓝灰 -> Swatch.BLUE_GREY
            else -> null
        }?.assignTo(scene)

    }

}