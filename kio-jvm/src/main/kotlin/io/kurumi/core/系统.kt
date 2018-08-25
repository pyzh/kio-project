package io.kurumi.core

import cn.hutool.core.util.ClipboardUtil
import io.kurumi.jvm.*

actual object 系统 {

    actual val Linux: Boolean = _Linux
    actual val Android: Boolean = _Android
    actual val Mac: Boolean = _Mac
    actual val MacOsx: Boolean = _MacOsx
    actual val Win: Boolean = _Win
    actual val WinXp: Boolean = _WinXp
    actual val Win7: Boolean = _Win7
    actual val Win8: Boolean = _Win8
    actual val Win10: Boolean = _Win10

    actual var 剪切板: String
        get() = ClipboardUtil.getStr()
        set(value) {
            ClipboardUtil.setStr(value)
        }


}