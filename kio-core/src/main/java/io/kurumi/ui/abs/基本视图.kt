package io.kurumi.ui.abs

import io.kurumi.ui.视图

interface 基本视图 {

    val 当前视图 : 视图

    var 宽度 : Int
    var 高度 :Int

    fun 置宽高(_宽高: Int)
    fun 置宽高(_宽度: Int, _高度: Int)

    fun 置填充(_填充: Int)

    var 上填充 : Int
    var 下填充 : Int
    var 左填充 : Int
    var 右填充 : Int

    fun 置填充(_上: Int, _下: Int, _左: Int, _右: Int)

}