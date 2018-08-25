package io.kurumi.core

import io.kurumi.jvm._编码
import io.kurumi.jvm._解码

actual object 链接编码实现 : 编码 {

    override fun 编码(_内容: ByteArray): ByteArray {
        return _编码(_内容)
    }

    override fun 解码(_内容: ByteArray): ByteArray? {
        return _解码(_内容)
    }

}

actual object Unicode编码实现 : 编码 {

    override fun 编码(_内容: ByteArray): ByteArray {
        return _编码(_内容)
    }

    override fun 解码(_内容: ByteArray): ByteArray? {
        return _解码(_内容)
    }

}