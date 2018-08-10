package io.kurumi.platform

import io.kurumi.content.界面
import io.kurumi.libs.JSELibs
import io.kurumi.ui.颜色

object 设备 {

    lateinit var 实现: 设备实现

    fun 初始化实现(实现: 设备实现) {
        this.实现 = 实现;
    }

    var 剪切板
        get() = 实现.剪切板
        set(value) {
            实现.剪切板 = value
        }

    fun 应用默认颜色(_界面: 界面,_颜色: 颜色) {

        if (JSELibs.isJavaFxThemeAvailable()) {



        }

    }

}