package io.kurumi.android.ui

import android.widget.Button
import io.kurumi.app.content.上下文
import io.kurumi.app.ui.abs.按钮
import io.kurumi.app.ui.颜色

open class 安卓按钮(_上下文 : 上下文, override val 内容 :Button = Button(取上下文(_上下文))) : 安卓文本视图(_上下文,内容),按钮 {

    init {

        (this as 安卓文本视图).文本颜色 = 颜色.白色

    }

}