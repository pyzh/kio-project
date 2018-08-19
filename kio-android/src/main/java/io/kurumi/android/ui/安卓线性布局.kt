package io.kurumi.android.ui

import android.widget.LinearLayout
import io.kurumi.platform.content.上下文
import io.kurumi.platform.ui.abs.基本线性布局
import io.kurumi.platform.ui.布局方向
import io.kurumi.platform.ui.布局重力

class 安卓线性布局(_上下文: 上下文, override val 内容: LinearLayout) : 安卓布局(_上下文, 内容), 基本线性布局 {

    override val 方向: 布局方向
        get() = 到方向(内容.orientation)

    override var 重力: 布局重力
        get() = TODO()
        set(value) {}

    fun 布局方向.到方向(): Int {
        return when (this) {
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