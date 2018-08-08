package io.kurumi.platform

object 设备 {

    lateinit var 实现: 设备实现

    fun 初始化实现(实现: 设备实现) {
        this.实现 = 实现;
    }

    var 剪切板
        get() = 实现.剪切板
        set(value) {
            实现.剪切板 = value
        }



}