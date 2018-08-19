package io.kurumi.platform.ui.view

import io.kurumi.platform.content.上下文
import io.kurumi.platform.ui.abs.基本线性布局
import io.kurumi.platform.取实现
import io.kurumi.service.abs.界面服务
import io.kurumi.service.服务类型

open class 线性布局 internal constructor(_上下文: 上下文, _实现: 基本线性布局, _初始化: (线性布局.() -> Unit)?) : 布局(_上下文, _实现), 基本线性布局 by _实现 {

    init {
        _初始化?.invoke(this)
    }

}

fun 上下文.垂直布局(_初始化: (线性布局.() -> Unit)? = null): 线性布局 {
    return 线性布局(this, (服务类型.界面.取实现() as 界面服务).新垂直布局(this), _初始化)
}

fun 布局.垂直布局(_初始化: (线性布局.() -> Unit)? = null): 线性布局 {
    val view = 线性布局(上下文, (服务类型.界面.取实现() as 界面服务).新垂直布局(上下文), _初始化)
    加入子视图(view)
    return view
}

fun 上下文.水平布局(_初始化: (线性布局.() -> Unit)? = null): 线性布局 {
    return 线性布局(this, (服务类型.界面.取实现() as 界面服务).新水平布局(this), _初始化)
}

fun 布局.水平布局(_初始化: (线性布局.() -> Unit)? = null): 线性布局 {
    val view = 线性布局(上下文, (服务类型.界面.取实现() as 界面服务).新水平布局(上下文), _初始化)
    加入子视图(view)
    return view
}