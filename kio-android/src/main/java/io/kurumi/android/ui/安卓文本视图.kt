package io.kurumi.android.ui

import android.widget.TextView
import io.kurumi.android.service.安卓界面服务
import io.kurumi.platform.content.上下文
import io.kurumi.platform.ui.abs.基本文本
import io.kurumi.util.主线程

open class 安卓文本视图(_上下文: 上下文, override val 内容: TextView = TextView(安卓界面服务.取安卓上下文(_上下文))) : 安卓视图(_上下文, 内容), 基本文本 {

    override var 文本: String
        get() = 内容.text.toString() ?: ""
        set(value) {
            主线程 {
                内容.text = value
            }
        }

    override var 文本颜色: Int
        get() = 内容.currentTextColor
        set(value) {
            内容.setTextColor(value)
        }
}