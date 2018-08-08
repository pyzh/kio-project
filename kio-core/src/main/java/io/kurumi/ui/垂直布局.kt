package io.kurumi.ui

import io.kurumi.content.上下文

class 垂直布局 : 线性布局 {

    constructor(_上下文: 上下文) : super(_上下文) {}

    constructor(_布局: 布局) : this(_布局.取上下文()) {
        _布局.加入子视图(this)
    }

    override fun 新实现(): 线性布局.实现 {
        return 设备.取当前系统().取视图实现().新线性布局实现(this)
    }

}
