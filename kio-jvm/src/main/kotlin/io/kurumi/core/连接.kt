package io.kurumi.core

actual internal class 结果实现 actual constructor(_结果: 连接.结果) {

    actual val 成功: Boolean
        get() = TODO()

    actual val 状态码: Int
        get() = TODO()

    actual val Cookie: MutableMap<String, String>
        get() = TODO()

    actual val 字节: ByteArray
        get() = TODO()

    actual val 字符: String
        get() = TODO()

    actual fun 保存(_地址: String) {}

}