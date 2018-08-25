package io.kurumi.core

expect class 文件 : Comparable<文件> {

    private constructor()

    var 名称: String

    var 目录: 文件
    var 地址: String

    var 扩展名: String
    var 去扩展名: String

    var 存在: Boolean
    var 是文件: Boolean
    var 是目录: Boolean

    var 子文件: MutableList<文件>

    var 字符: String
    var 字节: ByteArray

    var 可读: Boolean
    var 可写: Boolean
    var 可执行: Boolean

    var 最后修改时间: Long

    fun 追加(_字节: ByteArray)
    fun 追加(_字符: String)

    fun 子文件(_地址: String): 文件
    fun 复制到目录(_目录: 文件): 文件
    fun 复制到(_文件: 文件): 文件

    fun 打开()

    companion object {

        fun 可用(): Boolean
        fun 取实例(vararg _地址: String): 文件
        fun 取实例(_目录: 文件, vararg _地址: String): 文件

    }

}