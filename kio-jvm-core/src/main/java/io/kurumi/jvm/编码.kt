package io.kurumi.jvm

import cn.hutool.core.exceptions.UtilException
import cn.hutool.core.text.UnicodeUtil
import cn.hutool.core.util.URLUtil
import io.kurumi.bytes
import io.kurumi.catch
import io.kurumi.core.Unicode编码实现
import io.kurumi.core.链接编码实现
import io.kurumi.string

fun 链接编码实现._编码(_内容: ByteArray): ByteArray {
    return URLUtil.encode(_内容.string).bytes
}

fun 链接编码实现._解码(_内容: ByteArray): ByteArray? {
    return { URLUtil.decode(_内容.string).bytes }.catch<UtilException, ByteArray?> { null }
}

fun Unicode编码实现._编码(_内容: ByteArray): ByteArray {
    return UnicodeUtil.toUnicode(_内容.string).bytes
}

fun Unicode编码实现._解码(_内容: ByteArray): ByteArray? {
    return UnicodeUtil.toString(_内容.string).bytes
}