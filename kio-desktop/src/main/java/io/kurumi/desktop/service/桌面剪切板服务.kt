package io.kurumi.desktop.service

import cn.hutool.core.util.ClipboardUtil
import io.kurumi.service.剪切板服务

object 桌面剪切板服务 : 剪切板服务 {

    override var 文本: String
        get() = ClipboardUtil.getStr()
        set(value) = ClipboardUtil.setStr(value)

}