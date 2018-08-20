package io.kurumi.service

import io.kurumi.util.文件

interface 文件服务 : 基本服务 {

    val 私有目录: 文件
    fun 取私有地址(_地址: String): 文件

    fun 申请(_地址: String, _回调: (文件?.(_成功: Boolean) -> Unit))
    fun 打开(_文件: 文件)

}