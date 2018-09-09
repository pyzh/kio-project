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

package io.kurumi.core

import android.Manifest
import android.annotation.SuppressLint
import android.app.ActivityControl
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.webkit.MimeTypeMap
import io.kurumi.android.provider.FileProvider
import io.kurumi.android.安卓应用
import io.kurumi.android.安卓界面
import io.kurumi.jvm.*
import io.kurumi.util.提示
import java.io.File

actual class 文件 : Comparable<文件> {

    lateinit var 文件: File

    @Deprecated(message = "不要使用空参构造方法", level = DeprecationLevel.ERROR)
    actual constructor()

    constructor(_文件: File) {
        文件 = _文件
    }


    val uri: Uri
        get() {
            return if (Build.VERSION.SDK_INT > 23 && 安卓应用.实例.applicationInfo.targetSdkVersion > 23) {
                FileProvider.getPathStrategy(安卓应用.实例, "${安卓应用.实例.packageName}.fpv")
                        .getUriForFile(文件)
            } else {
                Uri.fromFile(文件)
            }
        }

    actual var 名称: String = _名称
    actual var 目录: 文件 = _目录
    actual var 地址: String = _地址
    actual var 扩展名: String = _扩展名
    actual var 去扩展名: String = _去扩展名
    actual var 存在: Boolean = _存在
    actual var 是文件: Boolean = _是文件
    actual var 是目录: Boolean = _是目录
    actual var 子文件: MutableList<文件> = _子文件
    actual var 字符: String = _字符
    actual var 字节: ByteArray = _字节
    actual var 可读: Boolean = _可读
    actual var 可写: Boolean = _可写
    actual var 可执行: Boolean = _可执行
    actual var 最后修改时间: Long = _最后修改时间
    actual fun 追加(_字节: ByteArray) = _追加(_字节)
    actual fun 追加(_字符: String) = _追加(_字符)
    actual fun 子文件(_地址: String) = _子文件(_地址)
    actual fun 复制到目录(_目录: 文件) = _复制到目录(_目录)
    actual fun 复制到(_文件: 文件) = _复制到(_文件)
    actual fun 打开() {

        val intent = Intent(android.content.Intent.ACTION_VIEW)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        val type = if (MimeTypeMap.getSingleton().hasExtension(扩展名))
            MimeTypeMap.getSingleton().getMimeTypeFromExtension(扩展名) else "*/*"
        intent.setDataAndType(uri, type)

        try {
            安卓应用.实例.startActivity(intent)
        } catch (ex: Exception) {
            提示("打开失败 : $地址")
        }
    }

    companion actual object {

        val 需要申请 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M

        actual fun 可用(): Boolean = true

        actual fun 取实例(vararg _地址: String): 文件 = _取实例(*_地址)
        actual fun 取实例(_目录: 文件, vararg _地址: String): 文件 = _取实例(_目录, *_地址)

        actual val 私有目录: 文件
            get() {
                return 文件.取实例(if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    安卓应用.实例.dataDir.path
                } else {
                    安卓应用.实例.filesDir.parent
                })
            }

        actual fun 取私有地址(_地址: String): 文件 {
            return 文件.取实例("${私有目录.地址}/$_地址")
        }

        @SuppressLint("NewApi")
        actual fun 申请(_回调: ((_成功: Boolean) -> Unit)) {

            if (!需要申请) {

                _回调(true)

            } else {

                val _界面 = ActivityControl.currentActivity as 安卓界面

                _界面.权限监听器.put(19132) {

                    _回调.invoke(it.getOrDefault(Manifest.permission.WRITE_EXTERNAL_STORAGE, false))

                }

                _界面.requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 19132)


            }

        }


    }

    override fun compareTo(other: 文件): Int = _compareTo(other)


}