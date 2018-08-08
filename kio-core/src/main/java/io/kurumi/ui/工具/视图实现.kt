package io.kurumi.ui.工具

import io.kurumi.ui.垂直布局
import io.kurumi.ui.布局
import io.kurumi.ui.视图
import io.kurumi.ui.文本视图
import io.kurumi.ui.水平布局
import io.kurumi.ui.线性布局

abstract class 视图实现 {

    abstract fun 新基本视图实现(_视图: 视图): 视图.实现

    abstract fun 新基本布局实现(_视图: 布局): 布局.实现

    abstract fun 新线性布局实现(_视图: 垂直布局): 线性布局.实现

    abstract fun 新线性布局实现(_视图: 水平布局): 线性布局.实现

    abstract fun 新文本视图实现(_视图: 文本视图): 文本视图.实现

}