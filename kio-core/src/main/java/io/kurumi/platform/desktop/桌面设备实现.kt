package io.kurumi.platform.desktop

import cn.hutool.core.util.ClipboardUtil
import io.kurumi.platform.视图实现
import io.kurumi.platform.设备实现
import io.kurumi.content.上下文
import io.kurumi.content.界面
import javafx.application.Platform

object 桌面设备实现 : 设备实现 {

    override var 剪切板: String
        get() = ClipboardUtil.getStr()
        set(value) = ClipboardUtil.setStr(value)

    override fun 主线程运行(_内容: () -> Unit) {
        Platform.runLater(_内容)
    }

    override fun 启动界面(_上下文: 上下文, _界面: Class<out 界面>) {
        桌面界面实现.启动界面(_上下文, _界面)
    }

    override val 视图实现: 视图实现
        get() = 桌面视图实现
}