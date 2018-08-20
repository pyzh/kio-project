package io.kurumi.desktop.service

import cn.hutool.core.io.FileUtil
import cn.hutool.core.util.RuntimeUtil
import io.kurumi.service.文件服务
import io.kurumi.util.文件

object 桌面文件服务 : 文件服务 {

    override val 私有目录: 文件
        get() = 文件.取实例(FileUtil.getTmpDir().getParent())

    override fun 取私有地址(_地址: String): 文件 {
        return 私有目录.子文件(_地址)
    }

    override fun 申请(_地址: String, _回调: 文件?.(_成功: Boolean) -> Unit) {
        _回调.invoke(文件.取实例(_地址), true)
    }

    override fun 打开(_文件: 文件) {
        RuntimeUtil.exec("rundll32.exe url.dll,FileProtocolHandler file://${_文件.地址}")
    }

}