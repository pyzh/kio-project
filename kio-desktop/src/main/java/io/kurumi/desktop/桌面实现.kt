package io.kurumi.desktop

import com.sun.javafx.application.PlatformImpl
import io.kurumi.desktop.service.桌面剪切板服务
import io.kurumi.desktop.service.桌面文件服务
import io.kurumi.desktop.service.桌面界面服务
import io.kurumi.platform.设备实现
import io.kurumi.service.abs.基本服务
import io.kurumi.service.服务类型

object 桌面实现 : 设备实现 {

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
            服务类型.文件 -> 桌面文件服务
            服务类型.剪切板 -> 桌面剪切板服务
            服务类型.界面 -> 桌面界面服务
            else -> error("不支持的服务 : $_服务")
        }
    }



}