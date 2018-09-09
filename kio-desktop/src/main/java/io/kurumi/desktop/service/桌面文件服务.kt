/*
 * Copyright 2018 MikaGuraNTK
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

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