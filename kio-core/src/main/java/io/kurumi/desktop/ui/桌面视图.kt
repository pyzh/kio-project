package io.kurumi.desktop.ui

import io.kurumi.content.上下文
import io.kurumi.ui.abs.基本视图
import io.kurumi.ui.widget.视图
import javafx.geometry.Insets
import javafx.scene.layout.Region

open class 桌面视图(open val 内容: Region) : 基本视图 {

    companion object {
        const val 键值_视图 = "_view"
    }

    constructor() : this(Region())

    override fun 初始化(视图: 视图) {
        置参数(键值_视图,视图)
    }

    fun 置参数(_键值 : String,_内容 : Any) {
        内容.properties[_键值] = _内容
    }

    @Suppress("UNCHECKED_CAST")
    fun <内容> 取参数(_键值 : String) : 内容? {
        return 内容.properties[_键值] as 内容?
    }

    override var 宽度: Double
        get() = 内容.prefWidth
        set(value) {
            内容.maxWidth = value
        }

    override var 高度: Double
        get() = 内容.prefHeight
        set(value) {
            内容.prefHeight = value
        }

    override fun 置宽高(_宽高: Double) {
        置宽高(_宽高, _宽高)
    }

    override fun 置宽高(_宽度: Double, _高度: Double) {
        宽度 = _宽度
        高度 = _高度
    }

    override fun 置填充(_填充: Double) {
        内容.padding = Insets(_填充)
    }

    override var 上填充: Double
        get() = 内容.padding.top
        set(value) {
            置填充(value,下填充, 左填充, 右填充)
        }

    override var 下填充: Double
        get() = 内容.padding.bottom
        set(value) {
            置填充(上填充,value, 左填充, 右填充)
        }

    override var 左填充: Double
        get() = 内容.padding.left
        set(value) {
            置填充(上填充,下填充, value, 右填充)
        }

    override var 右填充: Double
        get() = 内容.padding.right
        set(value) {
            置填充(上填充,下填充, 左填充, value)
        }

    override fun 置填充(_上: Double, _下: Double, _左: Double, _右: Double) {
       内容.padding = Insets(_上, _右, _下, _左)
    }

}