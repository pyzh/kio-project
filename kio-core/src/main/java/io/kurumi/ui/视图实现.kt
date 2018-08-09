package io.kurumi.ui

import io.kurumi.ui.abs.基本布局
import io.kurumi.ui.abs.基本文本
import io.kurumi.ui.abs.基本线性布局
import io.kurumi.ui.abs.基本视图
import io.kurumi.ui.layout.布局
import io.kurumi.ui.layout.线性布局
import io.kurumi.ui.widget.文本视图
import io.kurumi.ui.widget.视图

interface 视图实现 {

    fun 新视图实现(_视图: 视图): 基本视图
    fun 新布局实现(_视图: 布局): 基本布局
    fun 新文本视图实现(_视图: 文本视图): 基本文本

    fun 新垂直布局(_视图: 线性布局): 基本线性布局.垂直
    fun 新水平布局(_视图: 线性布局): 基本线性布局.水平

}