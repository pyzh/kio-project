package io.kurumi.android

import android.app.ActivityThread
import android.app.Application
import io.kurumi.android.service.安卓剪切板服务
import io.kurumi.android.service.安卓文件服务
import io.kurumi.android.service.安卓界面服务
import io.kurumi.platform.设备实现
import io.kurumi.service.abs.基本服务
import io.kurumi.service.服务类型

object 安卓实现 : 设备实现 {

    val 应用: Application = ActivityThread.currentApplication()


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
            服务类型.文件 -> 安卓文件服务
            服务类型.剪切板 -> 安卓剪切板服务
            服务类型.界面 -> 安卓界面服务
            else -> throw IllegalStateException("不支持的服务 : $_服务")
        }

    }

}