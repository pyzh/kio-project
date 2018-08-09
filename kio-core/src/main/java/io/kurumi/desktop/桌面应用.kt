package io.kurumi.desktop

import cn.hutool.core.lang.Caller

open class 桌面应用 {

    companion object {

        @JvmStatic
        fun launch() {

            println(Caller.getCaller())

        }

    }

}