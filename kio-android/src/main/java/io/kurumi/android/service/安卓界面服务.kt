package io.kurumi.android.service

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import io.kurumi.android.app.KurumiActivity
import io.kurumi.android.ui.安卓布局
import io.kurumi.android.ui.安卓文本视图
import io.kurumi.android.ui.安卓线性布局
import io.kurumi.android.ui.安卓视图
import io.kurumi.android.安卓应用
import io.kurumi.android.安卓界面

object 安卓界面服务 : 上下文 {

    val mainHandler = Handler(Looper.getMainLooper())

    override fun 主线程处理(_执行: () -> Unit) {
        if (Thread.currentThread() == Looper.getMainLooper().thread) {
            _执行.invoke()
        } else {
            mainHandler.post(_执行)
        }
    }

    fun 取安卓上下文(_上下文: 上下文): Context {
        if (_上下文 is 界面) {
            return _上下文.实现 as 安卓界面
        } else {
            return 安卓应用.实例
        }
    }

    override fun 启动界面(_上下文: 上下文, _界面: Class<out 界面>) {
        val _安卓上下文 = 取安卓上下文(_上下文)
        val _意图 = Intent(_安卓上下文, KurumiActivity::class.java)
        _意图.putExtra("_界面", _界面)
        _安卓上下文.startActivity(_意图)
    }

    override fun 新视图实现(_上下文: 上下文): 基本视图 {
        return 安卓视图(_上下文)
    }

    override fun 新布局实现(_上下文: 上下文): 基本布局 {
        return 安卓布局(_上下文)
    }

    override fun 新垂直布局(_上下文: 上下文): 基本线性布局.垂直 {
        return 安卓线性布局.垂直(_上下文)
    }

    override fun 新水平布局(_上下文: 上下文): 基本线性布局.水平 {
        return 安卓线性布局.水平(_上下文)
    }

    override fun 新文本视图实现(_上下文: 上下文): 基本文本 {
        return 安卓文本视图(_上下文)
    }
}