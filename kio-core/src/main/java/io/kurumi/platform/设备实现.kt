package io.kurumi.platform

import io.kurumi.content.上下文
import io.kurumi.content.界面

interface 设备实现 {

    var 剪切板: String
    fun 主线程运行(_内容: () -> Unit)
    fun 启动界面(_上下文: 上下文, _界面: Class<out 界面>)
    val 视图实现: 视图实现

}