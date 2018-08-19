package io.kurumi.desktop.service

import io.kurumi.desktop.ui.view.*
import io.kurumi.desktop.桌面界面
import io.kurumi.platform.content.上下文
import io.kurumi.platform.content.界面
import io.kurumi.platform.ui.abs.基本布局
import io.kurumi.platform.ui.abs.基本文本
import io.kurumi.platform.ui.abs.基本线性布局
import io.kurumi.platform.ui.abs.基本视图
import io.kurumi.service.abs.界面服务
import javafx.application.Platform

object 桌面界面服务 : 界面服务 {

    override fun 主线程处理(_上下文: 上下文, _执行: () -> Unit) {
        Platform.runLater(_执行)
    }

    override fun 启动界面(_上下文: 上下文, _界面: Class<out 界面>) {
        桌面界面.启动界面(_上下文, _界面)
    }

    override fun 新视图实现(_上下文: 上下文): 基本视图 {
        return 桌面视图(_上下文)
    }

    override fun 新布局实现(_上下文: 上下文): 基本布局 {
        return 桌面布局(_上下文)
    }

    override fun 新垂直布局(_上下文: 上下文): 基本线性布局.垂直 {
        return 桌面垂直布局(_上下文)
    }

    override fun 新水平布局(_上下文: 上下文): 基本线性布局.水平 {
        return 桌面水平布局(_上下文)
    }

    override fun 新文本视图实现(_上下文: 上下文): 基本文本 {
        return 桌面文本视图(_上下文)
    }


}