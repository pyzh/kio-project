package io.kurumi.service.abs

import io.kurumi.content.上下文
import io.kurumi.ui.abs.基本布局
import io.kurumi.ui.abs.基本文本
import io.kurumi.ui.abs.基本线性布局
import io.kurumi.ui.abs.基本视图

interface 界面服务 : 基本服务 {

    fun 主线程处理(_执行: () -> Unit)

    fun 新视图实现(_上下文: 上下文): 基本视图
    fun 新布局实现(_上下文: 上下文): 基本布局

    fun 新垂直布局(_上下文: 上下文): 基本线性布局.垂直
    fun 新水平布局(_上下文: 上下文): 基本线性布局.水平

    fun 新文本视图实现(_上下文: 上下文): 基本文本

}