package io.kurumi.desktop

import com.sun.javafx.application.PlatformImpl
import io.kurumi.desktop.service.桌面剪切板服务
import io.kurumi.desktop.service.桌面文件服务
import io.kurumi.desktop.service.桌面日志服务
import io.kurumi.desktop.service.桌面界面服务

object 桌面实现 : 设备实现() {

    init {
        PlatformImpl.startup { }

        注册服务(剪切板服务::class, 桌面剪切板服务)
        注册服务(文件服务::class, 桌面文件服务)
        注册服务(上下文::class, 桌面界面服务)
        注册服务(日志服务::class, 桌面日志服务)
    }

}