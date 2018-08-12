package io.kurumi.ui.view

import io.kurumi.content.上下文
import io.kurumi.platform.设备
import io.kurumi.ui.abs.基本文本

open class 文本视图 internal constructor(_上下文: 上下文, _实现: 基本文本) : 视图(_上下文, _实现), 基本文本 by _实现 {

    constructor(_上下文: 上下文, _初始化: (文本视图.() -> Unit)? = null) :
            this(_上下文, 设备.视图实现.新文本视图实现(_上下文)) {
        _初始化?.invoke(this)
    }
}

fun 上下文.文本视图(_初始化: (文本视图.() -> Unit)? = null): 文本视图 {
    val view = 文本视图(this, _初始化)
    return view
}

fun 布局.文本视图(_初始化: (文本视图.() -> Unit)? = null): 文本视图 {
    val view = 文本视图(上下文, _初始化)
    加入子视图(view)
    return view
}