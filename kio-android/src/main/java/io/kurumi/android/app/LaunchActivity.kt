package io.kurumi.android.app

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import io.kurumi.android.安卓应用

class LaunchActivity : Activity() {

    val permissions by lazy {
        packageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS).requestedPermissions
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(permissions, 19132)
            return
        }

        launch()
    }

    fun launch() {

        安卓应用.应用实例.应用启动事件()

        finish()

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>?, grantResults: IntArray?) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        launch()
    }

}