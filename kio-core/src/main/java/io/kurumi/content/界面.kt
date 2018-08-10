package io.kurumi.content

import io.kurumi.ui.view.视图

import java.io.Serializable

open class 界面 : 上下文, Serializable {

    private lateinit var 当前实现: 实现
    override val 应用: 应用 = 当前实现.应用

    var 标题: String
        get() = 当前实现.标题
        set(value) {
            当前实现.标题 = value
        }

    fun 初始化实现(_实现: 实现) {
        if (this::当前实现.isInitialized) throw IllegalStateException("已经初始化过了")
        当前实现 = _实现
    }

    fun 关闭() {
        当前实现.关闭()
    }

    open fun 界面创建事件() {
    }

    // =========================

    interface 实现 {

        fun 取界面(): 界面? {
            return null
        }

        fun 关闭()

        val 应用:应用
        var 标题: String
        var 视图: 视图?

    }

    // =========================

    companion object {

        @JvmStatic
        fun 启动界面(_上下文 : 上下文,_界面 : Class<out 界面>) {



        }

    }


}