package io.kurumi.android

import android.app.ActivityThread
import android.app.Application
import android.content.Context
import io.kurumi.platform.content.应用
import io.kurumi.platform.设备
import me.weishu.reflection.Reflection

abstract class 安卓应用 : Application() {

    companion object {
        val 实例: 安卓应用 get() = ActivityThread.currentApplication() as 安卓应用
        val 应用实例 get() = 实例.应用实例

        init {
            设备.初始化实现(安卓实现)
        }
    }

    abstract val 应用: Class<out 应用>
    private val 应用实例 = 应用.newInstance()

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Reflection.unseal(base) // support for androidP
    }

}