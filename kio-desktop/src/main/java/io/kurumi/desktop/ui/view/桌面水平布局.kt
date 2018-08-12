package io.kurumi.desktop.ui.view

import io.kurumi.content.上下文
import io.kurumi.ui.abs.基本线性布局
import javafx.scene.layout.HBox

class 桌面水平布局(_上下文: 上下文, override val 内容: HBox) : 桌面线性布局(_上下文, 内容), 基本线性布局.水平 {

    constructor(_上下文: 上下文) : this(_上下文, HBox())

}