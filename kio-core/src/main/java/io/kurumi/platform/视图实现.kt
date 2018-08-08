package io.kurumi.platform

import io.kurumi.content.上下文
import io.kurumi.ui.abs.基本布局
import io.kurumi.ui.abs.基本视图

interface 视图实现 {

    fun 新视图实现(_上下文: 上下文): 基本视图
    fun 新布局实现(_上下文: 上下文): 基本布局

}