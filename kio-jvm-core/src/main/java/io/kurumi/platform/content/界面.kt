package io.kurumi.platform.content

import io.kurumi.platform.ui.view.视图
import io.kurumi.platform.ui.颜色
import java.io.Serializable

abstract class 界面 : 上下文, Serializable {

    lateinit var 实现: 界面实现

    override final val 应用: 应用 get() = 实现.应用

    open var 标题
        get() = 实现.标题
        set(value) {
            实现.标题 = value
        }

    override fun 启动界面(_界面: Class<out 界面>) {
        实现.启动界面(_界面)
    }

    open var 内容
        get() = 实现.内容
        set(value) {
            实现.内容 = value
        }


    fun 初始化实现(_实现: 界面实现) {
        if (this::实现.isInitialized) throw IllegalStateException("已经初始化过了")
        实现 = _实现
    }

    open fun 关闭() {
        实现.关闭()
    }

    abstract fun 界面创建事件()

    // =========================

    interface 界面实现 {

        fun 关闭()

        val 应用: 应用
        var 标题: String
        var 内容: 视图?

        fun 启动界面(_界面: Class<out 界面>) = 应用.启动界面(_界面)

        fun 应用颜色(_颜色: 颜色)

    }


}