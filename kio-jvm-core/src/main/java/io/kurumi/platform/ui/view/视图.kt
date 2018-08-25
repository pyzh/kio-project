package io.kurumi.platform.ui.view

import io.kurumi.platform.content.上下文

interface 视图 {

    val 上下文: 上下文

    var 宽度: Int
    var 高度: Int

    var 宽高: Int

    var 上填充: Int
    var 下填充: Int
    var 左填充: Int
    var 右填充: Int
    var 填充: Int

    var 背景颜色: Int

    var 显示: Boolean

    var 阴影: Int

    var 单击事件: () -> Unit
    var 附加事件: () -> Unit


    fun 置填充(_上: Int, _下: Int, _左: Int, _右: Int)

}

fun 上下文.视图(_初始化: (视图.() -> Unit)? = null): 视图 {
    val view = 新视图实现()
    return view
}

fun 布局.视图(_初始化: (视图.() -> Unit)? = null): 视图 {
    val view = 视图(上下文, _初始化)
    加入子视图(view)
    return view
}