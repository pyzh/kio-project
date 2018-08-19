package io.kurumi.platform.ui.abs

import io.kurumi.platform.ui.布局方向
import io.kurumi.platform.ui.布局重力

interface 基本线性布局 : 基本布局 {

    val 方向: 布局方向
    var 重力: 布局重力

    interface 水平 : 基本线性布局 {
        override val 方向: 布局方向 get() = 布局方向.水平
    }

    interface 垂直 : 基本线性布局 {
        override val 方向: 布局方向 get() = 布局方向.垂直
    }

}