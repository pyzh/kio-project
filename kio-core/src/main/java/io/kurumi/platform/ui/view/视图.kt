package io.kurumi.platform.ui.view

import io.kurumi.platform.content.上下文
import io.kurumi.platform.ui.abs.基本视图
import io.kurumi.platform.取实现
import io.kurumi.service.abs.界面服务
import io.kurumi.service.服务类型

open class 视图 internal constructor(val 上下文: 上下文, val 实现: 基本视图) : 基本视图 by 实现 {

    constructor(_上下文: 上下文, _初始化: (视图.() -> Unit)? = null) :
            this(_上下文, (服务类型.界面.取实现() as 界面服务).新视图实现(_上下文)) {
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