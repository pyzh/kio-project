package io.kurumi.desktop

import cn.hutool.core.io.FileUtil
import cn.hutool.core.util.ClipboardUtil
import cn.hutool.core.util.RuntimeUtil
import com.sun.javafx.application.PlatformImpl
import io.kurumi.desktop.ui.view.*
import io.kurumi.platform.content.上下文
import io.kurumi.platform.ui.abs.基本布局
import io.kurumi.platform.ui.abs.基本文本
import io.kurumi.platform.ui.abs.基本线性布局
import io.kurumi.platform.ui.abs.基本视图
import io.kurumi.platform.设备实现
import io.kurumi.service.abs.剪切板服务
import io.kurumi.service.abs.基本服务
import io.kurumi.service.abs.文件服务
import io.kurumi.service.abs.界面服务
import io.kurumi.service.服务类型
import io.kurumi.util.文件
import javafx.application.Platform

object 桌面实现 : 设备实现, 界面服务, 剪切板服务, 文件服务 {

    init {
        PlatformImpl.startup { }
    }

    override fun 服务可用(_服务: 服务类型): Boolean {
        return when (_服务) {
            服务类型.文件 -> true
            服务类型.剪切板 -> true
            服务类型.界面 -> true
            else -> false
        }
    }

    override fun 取服务(_服务: 服务类型): 基本服务 {
        return when (_服务) {
            服务类型.文件 -> this
            服务类型.剪切板 -> this
            服务类型.界面 -> this
            else -> error("不支持的服务 : $_服务")
        }
    }

    override fun 主线程处理(_执行: () -> Unit) {
        Platform.runLater(_执行)
    }

    override var 文本: String
        get() = ClipboardUtil.getStr()
        set(value) = ClipboardUtil.setStr(value)

    override val 私有目录: 文件
        get() = 文件.取实例(FileUtil.getTmpDir().getParent())

    override fun 取私有地址(_地址: String): 文件 {
        return 私有目录.子文件(_地址)
    }

    override fun 申请(_地址: String, _回调: 文件?.(_成功: Boolean) -> Unit) {
        _回调.invoke(文件.取实例(_地址), true)
    }

    override fun 文件.打开() {
        RuntimeUtil.exec("rundll32 url.dll file://${this.地址}")
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