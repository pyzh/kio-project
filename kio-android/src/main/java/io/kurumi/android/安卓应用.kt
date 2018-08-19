package io.kurumi.android

import android.app.ActivityThread
import android.app.Application
import io.kurumi.content.应用

abstract class 安卓应用 : Application() {

    companion object {
        val 实例: 安卓应用 = ActivityThread.currentApplication() as 安卓应用
        val 应用实例 get() = 实例.应用实例
    }

    abstract val 应用: Class<out 应用>
    private val 应用实例 = 应用.newInstance()

    init {

    }

}