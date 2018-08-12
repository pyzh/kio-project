package io.kurumi.platform

import io.kurumi.content.上下文
import io.kurumi.content.界面

object 设备 {

    private lateinit var 实现: 设备实现

    val 视图实现
        get() = 实现.视图实现

    fun 初始化实现(实现: 设备实现) {
        this.实现 = 实现;
    }

    var 剪切板
        get() = 实现.剪切板
        set(value) {
            实现.剪切板 = value
        }

    fun 主线程运行(_内容: () -> Unit) {
        实现.主线程运行(_内容)
    }

    fun 启动界面(_上下文: 上下文, _界面: Class<out 界面>) {
        实现.启动界面(_上下文, _界面)
    }

}

fun (() -> Unit).主线程运行() {

    设备.主线程运行(this)

}