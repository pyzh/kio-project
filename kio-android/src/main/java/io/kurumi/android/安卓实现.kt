package io.kurumi.android

import android.app.ActivityControl
import android.app.ActivityThread
import android.app.Application
import io.kurumi.content.上下文
import io.kurumi.content.界面
import io.kurumi.platform.设备实现
import io.kurumi.ui.视图实现
import android.content.ClipData
import android.content.ClipDescription
import android.os.Handler
import android.os.Looper

object 安卓实现 : 设备实现 {

    val 应用 : Application = ActivityThread.currentApplication()
    val IMEI = 系统服务.设备管理.meid
    val IMSI = 系统服务.设备管理.subscriberId

    private val 主线程处理器 = Handler(Looper.getMainLooper())

    override var 剪切板: String
        get() {
            if (系统服务.剪切板.hasPrimaryClip() && 系统服务.剪切板.primaryClipDescription.hasMimeType(
                            ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                val _数据 = 系统服务.剪切板.primaryClip
                if (_数据 != null && _数据.itemCount > 0) {
                    return _数据.getItemAt(0).coerceToText(应用).toString()
                }
            }
            return ""
        }
        set(value) {
            系统服务.剪切板.primaryClip = ClipData.newPlainText(null, value)
        }

    override fun 主线程运行(_内容: () -> Unit) {
        主线程处理器.post(_内容)
    }

    override fun 启动界面(_上下文: 上下文, _界面: Class<out 界面>) {
        TODO()
    }

    override val 视图实现: 视图实现
        get() = TODO()

}