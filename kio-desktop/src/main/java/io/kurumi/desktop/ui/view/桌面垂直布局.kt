package io.kurumi.desktop.ui.view

import io.kurumi.platform.content.上下文
import io.kurumi.platform.ui.abs.基本线性布局
import javafx.scene.layout.VBox

open class 桌面垂直布局(_上下文: 上下文, override val 内容: VBox = VBox()) : 桌面线性布局(_上下文, 内容), 基本线性布局.垂直 {

}