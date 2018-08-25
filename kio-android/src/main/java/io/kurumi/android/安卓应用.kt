package io.kurumi.android

import android.app.ActivityThread
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
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
    val 信息 by lazy {
        packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)!!
    }
    val 版本 by lazy {
        if (Build.VERSION.SDK_INT >= 28) {
            信息.longVersionCode.toInt()
        } else {
            @Suppress("DEPRECATION")
            信息.versionCode
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Reflection.unseal(base) // support for androidP
    }

}