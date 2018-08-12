package io.kurumi.content

import io.kurumi.ui.view.视图
import io.kurumi.ui.颜色
import java.io.Serializable

abstract class 界面 : 上下文, Serializable {

    private lateinit var 当前实现: 实现
    override final val 应用: 应用 get() = 当前实现.应用

    open var 标题
        get() = 当前实现.标题
        set(value) {
            当前实现.标题 = value
        }

    open var 内容
        get() = 当前实现.内容
        set(value) {
            当前实现.内容 = value
        }


    fun 初始化实现(_实现: 实现) {
        if (this::当前实现.isInitialized) throw IllegalStateException("已经初始化过了")
        当前实现 = _实现
    }

    open fun 关闭() {
        当前实现.关闭()
    }

    abstract fun 界面创建事件()

    // =========================

    interface 实现 {

        fun 关闭()

        val 应用: 应用
        var 标题: String
        var 内容: 视图?

        fun 应用颜色(_颜色: 颜色)

    }


}