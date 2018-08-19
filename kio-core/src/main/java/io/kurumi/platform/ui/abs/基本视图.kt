package io.kurumi.platform.ui.abs

import io.kurumi.platform.ui.view.视图

interface 基本视图 {

    fun 初始化(_视图: 视图)

    var 宽度: Int
    var 高度: Int

    var 宽高: Int

    var 上填充: Int
    var 下填充: Int
    var 左填充: Int
    var 右填充: Int
    var 填充: Int

    var 显示: Boolean

    fun 置填充(_上: Int, _下: Int, _左: Int, _右: Int)

}