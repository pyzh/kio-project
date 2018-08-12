package io.kurumi.android

import android.app.Activity
import android.os.Bundle
import io.kurumi.content.应用
import io.kurumi.content.界面
import io.kurumi.ui.view.视图
import io.kurumi.ui.颜色

open class 安卓界面 : Activity(), 界面.实现 {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun 关闭() {
        finish()
    }

    override val 应用: 应用
        get() = 安卓应用.实例.应用

    override var 标题: String
        get() = title.toString()
        set(value) {
            title = value
        }

    override var 内容: 视图?
        get() = TODO()
        set(value) {}

    override fun 应用颜色(_颜色: 颜色) {
        TODO()
    }

}
