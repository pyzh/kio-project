package io.kurumi.util

import java.util.concurrent.Executor
import java.util.concurrent.Executors

open class 线程池 private constructor(val _线程池: Executor) {

    constructor() : this(Executors.newCachedThreadPool())
    constructor(_最大线程: Int) : this(Executors.newFixedThreadPool(_最大线程))


    fun 处理(_执行: () -> Unit) {
        _线程池.execute(_执行)
    }

    companion object : 线程池(10)

}

fun 异步(_执行: () -> Unit) {

    线程池.处理(_执行)

}

fun 线程(_执行: () -> Unit) {

    Thread(_执行).start()

}