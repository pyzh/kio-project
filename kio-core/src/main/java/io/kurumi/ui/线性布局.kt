package io.kurumi.ui

import io.kurumi.content.上下文
import io.kurumi.ui.工具.布局重力

abstract class 线性布局 : 布局 {

    constructor(_上下文: 上下文) : super(_上下文) {}

    constructor(_布局: 布局) : this(_布局.取上下文()) {
        _布局.加入子视图(this)
    }

    fun 置重力(_重力: 布局重力) {
        取实现().置重力(_重力)
    }

    fun 取实现(): 实现 {
        return super.取实现() as 线性布局.实现
    }

    protected abstract fun 新实现(): 实现

    interface 实现 : 布局.实现 {

        fun 置重力(_布局重力: 布局重力)

    }

}