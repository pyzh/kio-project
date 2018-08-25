package io.kurumi.desktop.ui.view

import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.input.MouseButton
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.Region
import javafx.scene.paint.Color

open class 桌面视图(val 上下文: 上下文, open val 内容: Region = Region()) : 基本视图 {

    companion object {
        const val 键值_视图 = "_view"
    }

    override fun 初始化(_视图: 视图) {
        置参数(键值_视图, _视图)
    }

    fun 置参数(_键值: String, _内容: Any) {
        内容.properties[_键值] = _内容
    }

    @Suppress("UNCHECKED_CAST")
    fun <内容> 取参数(_键值: String): 内容? {
        return 内容.properties[_键值] as 内容?
    }

    override var 宽度: Int
        get() = 内容.prefWidth.toInt()
        set(value) {
            内容.maxWidth = value.toDouble()
        }

    override var 高度: Int
        get() = 内容.prefHeight.toInt()
        set(value) {
            内容.prefHeight = value.toDouble()
        }

    override var 宽高: Int
        get() = if (宽度 == 高度) 宽度 else -1
        set(value) {
            宽度 = value
            高度 = value
        }

    override var 填充: Int
        get() = 内容.padding.top.toInt()
        set(value) {
            内容.padding = Insets(value.toDouble())
        }

    override var 上填充: Int
        get() = 内容.padding.top.toInt()
        set(value) {
            置填充(value, 下填充, 左填充, 右填充)
        }

    override var 下填充: Int
        get() = 内容.padding.bottom.toInt()
        set(value) {
            置填充(上填充, value, 左填充, 右填充)
        }

    override var 左填充: Int
        get() = 内容.padding.left.toInt()
        set(value) {
            置填充(上填充, 下填充, value, 右填充)
        }

    override var 右填充: Int
        get() = 内容.padding.right.toInt()
        set(value) {
            置填充(上填充, 下填充, 左填充, value)
        }

    override fun 置填充(_上: Int, _下: Int, _左: Int, _右: Int) {
        内容.padding = Insets(_上.toDouble(), _右.toDouble(), _下.toDouble(), _左.toDouble())
    }

    override var 显示: Boolean
        get() = 内容.isVisible
        set(value) {
            内容.isVisible = value
        }

    override var 背景颜色: Int
        get() = -1
        set(value) {
            内容.background = Background(BackgroundFill(value.toColor(), null, null))
        }

    override var 阴影: Int
        get() = 内容.translateZ.toInt()
        set(value) {
            内容.translateZ = value.toDouble()
        }

    init {
        内容.onMouseClicked = EventHandler {
            when (it) {
                MouseButton.PRIMARY -> 单击事件()
                MouseButton.SECONDARY -> 附加事件()
            }
        }
    }

    override var 单击事件: () -> Unit = {}
    override var 附加事件: () -> Unit = {}

}

fun Int.toColor(): Color {
    val lv = toLong()
    return Color.rgb(red(lv).toInt(), green(lv).toInt(), blue(lv).toInt(), alpha(lv).toDouble())
}