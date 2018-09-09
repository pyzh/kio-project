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

package io.kurumi.desktop

import com.sun.javafx.application.PlatformImpl
import io.kurumi.desktop.service.桌面剪切板服务
import io.kurumi.desktop.service.桌面文件服务
import io.kurumi.desktop.service.桌面日志服务
import io.kurumi.desktop.service.桌面界面服务

object 桌面实现 : 设备实现() {

    init {
        PlatformImpl.startup { }

        注册服务(剪切板服务::class, 桌面剪切板服务)
        注册服务(文件服务::class, 桌面文件服务)
        注册服务(上下文::class, 桌面界面服务)
        注册服务(日志服务::class, 桌面日志服务)
    }

}