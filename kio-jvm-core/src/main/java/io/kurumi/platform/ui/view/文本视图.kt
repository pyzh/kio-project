package io.kurumi.platform.ui.view

import io.kurumi.platform.content.上下文
import io.kurumi.platform.ui.abs.基本文本
import io.kurumi.service.实现

open class 文本视图 internal constructor(_上下文: 上下文, _实现: 基本文本) : 视图(_上下文, _实现), 基本文本 by _实现 {

    constructor(_上下文: 上下文, _初始化: (文本视图.() -> Unit)? = null) :
            this(_上下文, 上下文::class.实现.新文本视图实现(_上下文)) {
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