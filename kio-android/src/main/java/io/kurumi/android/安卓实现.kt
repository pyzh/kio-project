package io.kurumi.android

import io.kurumi.android.service.安卓剪切板服务
import io.kurumi.android.service.安卓文件服务
import io.kurumi.android.service.安卓日志服务
import io.kurumi.android.service.安卓界面服务

object 安卓实现 : 设备实现() {

    init {
        注册服务(剪切板服务::class, 安卓剪切板服务)
        注册服务(文件服务::class, 安卓文件服务)
        注册服务(上下文::class, 安卓界面服务)
        注册服务(日志服务::class, 安卓日志服务)
    }

}