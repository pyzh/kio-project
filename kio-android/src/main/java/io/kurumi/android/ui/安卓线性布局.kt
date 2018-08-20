package io.kurumi.android.ui

import android.os.Build
import android.widget.LinearLayout
import cn.hutool.core.util.ReflectUtil
import io.kurumi.android.service.安卓界面服务
import io.kurumi.android.安卓布局重力
import io.kurumi.platform.content.上下文
import io.kurumi.platform.ui.abs.基本线性布局
import io.kurumi.platform.ui.布局方向
import io.kurumi.platform.ui.布局重力
import io.kurumi.util.主线程

abstract class 安卓线性布局(_上下文: 上下文, override val 内容: LinearLayout = LinearLayout(安卓界面服务.取安卓上下文(_上下文))) : 安卓布局(_上下文, 内容), 基本线性布局 {

    val gravityRef: Int
        get() {
            return ReflectUtil.getFieldValue(内容, "mGravity") as Int
        }

    override var 重力: 布局重力
        get() {
            return 安卓布局重力.到重力(if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                内容.gravity
            } else {
                gravityRef
            })
        }
        set(value) {
            主线程 {
                内容.gravity = 安卓布局重力.到重力(value)
            }
        }

    companion object {

        fun 到方向(_方向: 布局方向): Int {
            return when (_方向) {
                布局方向.水平 -> LinearLayout.HORIZONTAL
                布局方向.垂直 -> LinearLayout.VERTICAL
            }
        }

        fun 到方向(_方向: Int): 布局方向 {
            return when (_方向) {
                LinearLayout.HORIZONTAL -> 布局方向.水平
                LinearLayout.VERTICAL -> 布局方向.垂直
                else -> error("无效的安卓布局方向 : _方向")
            }
        }

    }

    open class 垂直(_上下文: 上下文) : 安卓线性布局(_上下文), 基本线性布局.垂直 {
        init {
            内容.orientation = 到方向(布局方向.垂直)
        }
    }

    open class 水平(_上下文: 上下文) : 安卓线性布局(_上下文), 基本线性布局.水平 {
        init {
            内容.orientation = 到方向(布局方向.水平)
        }
    }

}