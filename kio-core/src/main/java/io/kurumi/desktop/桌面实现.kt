package io.kurumi.desktop

import cn.hutool.core.util.ClipboardUtil
import io.kurumi.content.上下文
import io.kurumi.content.界面
import io.kurumi.desktop.ui.view.*
import io.kurumi.platform.设备实现
import io.kurumi.ui.abs.基本布局
import io.kurumi.ui.abs.基本文本
import io.kurumi.ui.abs.基本线性布局
import io.kurumi.ui.abs.基本视图
import io.kurumi.ui.视图实现
import javafx.application.Platform

object 桌面实现 : 设备实现, 视图实现 {

    override var 剪切板: String
        get() = ClipboardUtil.getStr()
        set(value) = ClipboardUtil.setStr(value)

    override fun 主线程运行(_内容: () -> Unit) {
        Platform.runLater(_内容)
    }

    override fun 启动界面(_上下文: 上下文, _界面: Class<out 界面>) {
        桌面界面.启动界面(_上下文, _界面)
    }

    override val 视图实现: 视图实现
        get() = this

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