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

package io.kurumi.service

import io.kurumi.util.文件

interface 文件服务 : 基本服务 {

    val 私有目录: 文件
    fun 取私有地址(_地址: String): 文件

    fun 申请(_地址: String, _回调: (文件?.(_成功: Boolean) -> Unit))
    fun 打开(_文件: 文件)

}