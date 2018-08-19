package io.kurumi.platform

import io.kurumi.service.abs.基本服务
import io.kurumi.service.服务类型

interface 设备实现 {

    fun 服务可用(_服务: 服务类型): Boolean
    fun 取服务(_服务: 服务类型): 基本服务

}