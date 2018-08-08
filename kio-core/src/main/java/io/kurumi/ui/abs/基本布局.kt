package io.kurumi.ui.abs

import io.kurumi.ui.视图

interface 基本布局 : 基本视图 {

    fun 加入子视图(vararg _视图: 视图)

    fun 取子视图(_键值: Int): 视图

    fun 取子视图(): Array<视图>

    fun 删子视图(_键值: Int): 视图

    fun 删子视图(): Array<视图>

}