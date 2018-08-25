package io.kurumi.data

/**
 * 可转换到String的数据类型
 */
interface 数据 {

    fun toData(): String

    interface 监听器<内容 : Any> {

        fun 添加(_内容: Collection<内容>)
        fun 删除(_内容: Collection<内容>)

    }

}