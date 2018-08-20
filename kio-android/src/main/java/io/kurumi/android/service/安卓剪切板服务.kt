package io.kurumi.android.service

import android.content.ClipData
import io.kurumi.android.安卓应用
import io.kurumi.android.系统服务
import io.kurumi.service.剪切板服务

object 安卓剪切板服务 : 剪切板服务 {

    override var 文本: String
        get() {
            val _数据 = 系统服务.剪切板.primaryClip
            if (_数据 != null && _数据.itemCount > 0) {
                return _数据.getItemAt(0).coerceToText(安卓应用.实例).toString()
            }
            return ""
        }
        set(value) {
            系统服务.剪切板.primaryClip = ClipData.newPlainText(null, value)
        }

}