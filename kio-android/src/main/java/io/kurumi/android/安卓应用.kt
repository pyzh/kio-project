/*
 * Copyright 2018 MikaGuraNTK
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package io.kurumi.android

import android.app.ActivityThread
import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import io.kurumi.android.app.KurumiActivity
import io.kurumi.app.content.界面
import me.weishu.reflection.Reflection
import kotlin.concurrent.thread
import kotlin.reflect.KClass

abstract class 安卓应用 : Application() {

    companion object {
        val 实例: 安卓应用 get() = ActivityThread.currentApplication() as 安卓应用
    }

    abstract fun 应用启动事件(_上下文: Context)
    open fun 应用关闭事件() {
    }

    fun 启动界面(_界面: KClass<out 界面>) {
        val _意图 = Intent(this, KurumiActivity::class.java)
        _意图.putExtra("_界面", _界面.java)
        _意图.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(_意图)
    }

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

    override fun onCreate() {
        super.onCreate()
        Runtime.getRuntime().addShutdownHook(thread(false, false, null,
                "KioRuntimeShutdownHook") {
            应用关闭事件()
        })
    }
}