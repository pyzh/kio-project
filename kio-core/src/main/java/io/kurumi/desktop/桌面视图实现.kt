package io.kurumi.desktop

import io.kurumi.content.上下文
import io.kurumi.desktop.ui.桌面视图
import io.kurumi.ui.视图实现
import io.kurumi.ui.abs.基本布局
import io.kurumi.ui.abs.基本文本
import io.kurumi.ui.abs.基本线性布局
import io.kurumi.ui.abs.基本视图
import io.kurumi.ui.layout.布局
import io.kurumi.ui.layout.线性布局
import io.kurumi.ui.widget.文本视图
import io.kurumi.ui.widget.视图

object 桌面视图实现 : 视图实现 {

    override fun 新视图实现(_视图: 视图): 基本视图 {
        return 桌面视图(_视图)
    }

    override fun 新布局实现(_视图: 布局): 基本布局 {
        TODO()
    }

    override fun 新文本视图实现(_视图: 文本视图): 基本文本 {
        TODO()
    }

    override fun 新垂直布局(_视图: 线性布局): 基本线性布局.垂直 {
        TODO()
    }

    override fun 新水平布局(_视图: 线性布局): 基本线性布局.水平 {
        TODO()
    }
}