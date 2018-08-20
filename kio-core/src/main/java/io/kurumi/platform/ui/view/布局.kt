package io.kurumi.platform.ui.view

import io.kurumi.platform.content.上下文
import io.kurumi.platform.ui.abs.基本布局
import io.kurumi.service.实现
import io.kurumi.service.界面服务

open class 布局 internal constructor(_上下文: 上下文, _实现: 基本布局) : 视图(_上下文, _实现), 基本布局 by _实现 {

    constructor(_上下文: 上下文, _初始化: (布局.() -> Unit)?) : this(_上下文, 界面服务::class.实现.新布局实现(_上下文))

}

fun 上下文.布局(_初始化: (布局.() -> Unit)? = null): 布局 {
    return 布局(this, _初始化)
}

fun 布局.布局(_初始化: (布局.() -> Unit)? = null): 布局 {
    val view = 布局(上下文, _初始化)
    加入子视图(view)
    return view
}