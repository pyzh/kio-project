package io.kurumi.desktop.ui.view

import io.kurumi.platform.content.上下文
import io.kurumi.platform.ui.*
import io.kurumi.platform.ui.abs.基本文本
import javafx.scene.control.Label
import javafx.scene.paint.Color

open class 桌面文本视图(_上下文: 上下文, override val 内容: Label) : 桌面视图(_上下文, 内容), 基本文本 {

    constructor(_上下文: 上下文) : this(_上下文, Label())

    override var 文本: String
        get() = 内容.text
        set(value) {
            内容.text = value
        }

    override var 文本颜色: Int
        get() = "#${内容.textFill}".toIntColor()
        set(value) {
            val lv = value.toLong()
            内容.textFill = Color.rgb(red(lv).toInt(), green(lv).toInt(), blue(lv).toInt(), alpha(lv).toDouble())
        }

}