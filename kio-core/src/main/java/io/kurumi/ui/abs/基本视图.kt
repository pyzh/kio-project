package io.kurumi.ui.abs

import io.kurumi.ui.view.视图

interface 基本视图 {

    fun 初始化(视图: 视图)

    var 宽度 : Double
    var 高度 :Double

    var 宽高: Double

    var 上填充 : Double
    var 下填充 : Double
    var 左填充 : Double
    var 右填充 : Double
    var 填充: Double

    fun 置填充(_上: Double, _下: Double, _左: Double, _右: Double)

}