package io.kurumi.platform.content

import io.kurumi.platform.ui.abs.基本布局
import io.kurumi.platform.ui.abs.基本文本
import io.kurumi.platform.ui.abs.基本线性布局
import io.kurumi.platform.ui.abs.基本视图

interface 上下文 {

    fun 启动界面(_界面: Class<out 界面>)

    fun 新视图实现(): 基本视图
    fun 新布局实现(): 基本布局
    fun 新垂直布局(): 基本线性布局.垂直
    fun 新水平布局(): 基本线性布局.水平
    fun 新文本视图实现(): 基本文本

}