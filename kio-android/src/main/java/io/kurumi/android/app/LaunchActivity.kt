/*
 * Copyright 2018 MikaGuraNTK
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.kurumi.android.app

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import io.kurumi.android.安卓应用
import io.kurumi.core.文件

class LaunchActivity : Activity() {

    val permissions by lazy {
        packageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS).requestedPermissions
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 23) {

            val lock = 文件.取私有地址("versionlock-${安卓应用.实例.版本}")

            if (!lock.是文件) {

                lock.是文件 = true
                requestPermissions(permissions, 19132)
                return

            }


        }

        launch()
    }

    fun launch() {

        安卓应用.实例.应用启动事件()

        finish()

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>?, grantResults: IntArray?) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        launch()
    }

}