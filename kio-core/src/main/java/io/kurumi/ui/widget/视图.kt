package io.kurumi.ui.widget

import io.kurumi.content.上下文
import io.kurumi.platform.设备
import io.kurumi.ui.abs.基本视图
import io.kurumi.ui.layout.布局

open class 视图 internal constructor(val 上下文: 上下文,val 实现: 基本视图) : 基本视图 by 实现 {

    constructor(_上下文: 上下文, _初始化: (视图.() -> Unit)? = null) :
            this(_上下文, 设备.实现.视图实现.新视图实现()) {
        实现.初始化(this)
        _初始化?.invoke(this)
    }

}

fun 上下文.视图(_初始化: (视图.() -> Unit)? = null): 视图 {
    val view = 视图(this, _初始化)
    return view
}

fun 布局.视图(_初始化: (视图.() -> Unit)? = null): 视图 {
    val view = 视图(上下文, _初始化)
    加入子视图(view)
    return view
}