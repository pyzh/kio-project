package io.kurumi.android.service

import android.os.Handler
import android.os.Looper
import io.kurumi.content.上下文
import io.kurumi.service.abs.界面服务
import io.kurumi.ui.abs.基本布局
import io.kurumi.ui.abs.基本文本
import io.kurumi.ui.abs.基本线性布局
import io.kurumi.ui.abs.基本视图

object 安卓界面服务 : 界面服务 {

    val mainHandler = Handler(Looper.getMainLooper())

    override fun 主线程处理(_执行: () -> Unit) {
        mainHandler.post(_执行)
    }

    fun px2dp(_px: Double) {

    }

    override fun 新视图实现(_上下文: 上下文): 基本视图 {
        TODO()
    }

    override fun 新布局实现(_上下文: 上下文): 基本布局 {
        TODO()
    }

    override fun 新垂直布局(_上下文: 上下文): 基本线性布局.垂直 {
        TODO()
    }

    override fun 新水平布局(_上下文: 上下文): 基本线性布局.水平 {
        TODO()
    }

    override fun 新文本视图实现(_上下文: 上下文): 基本文本 {
        TODO()
    }
}