package io.kurumi.android.service

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.annotation.SuppressLint
import android.app.ActivityControl
import android.content.Intent
import android.net.Uri
import android.os.Build
import io.kurumi.android.provider.FileProvider
import io.kurumi.android.安卓应用
import io.kurumi.android.安卓界面
import io.kurumi.service.abs.文件服务
import io.kurumi.util.文件


object 安卓文件服务 : 文件服务 {

    val 需要申请 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

    override val 私有目录 = 文件.取实例(if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        安卓应用.实例.dataDir.path
    } else {
        安卓应用.实例.filesDir.parent
    })

    override fun 取私有地址(_地址: String): 文件 {
        return 文件.取实例("${私有目录.地址}/$_地址")
    }

    override fun 文件.打开() {

        val _意图 = Intent("android.intent.action.VIEW")

    }

    @SuppressLint("NewApi")
    override fun 申请(_地址: String, _回调: 文件?.(_成功: Boolean) -> Unit) {

        var _文件 = _地址

        if (_地址.startsWith("content://")) {

            val _文件 = FileProvider.getPathStrategy(安卓应用.实例, "${安卓应用.实例.packageName}.fpv").getFileForUri(Uri.parse(_地址)).path

        }

        if (!需要申请) {

            _回调.invoke(文件.取实例(_文件), true)

        } else {

            val _界面 = ActivityControl.currentActivity as 安卓界面

            _界面.权限监听器.put(19132) {

                _回调.invoke(文件.取实例(_文件), it.getOrDefault(WRITE_EXTERNAL_STORAGE, false))

            }

            _界面.requestPermissions(arrayOf(WRITE_EXTERNAL_STORAGE), 19132)


        }

    }

}