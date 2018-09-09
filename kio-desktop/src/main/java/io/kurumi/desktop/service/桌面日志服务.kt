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

import io.kurumi.service.日志服务
import java.util.*

object 桌面日志服务 : 日志服务 {

    @Suppress("DEPRECATION")
    override fun 打印(level: 日志服务.Level, log: Any?) {
        when (level) {
            日志服务.Level.Warning, 日志服务.Level.Error -> System.err.println("[Kurumi][${Date().toLocaleString()}]{log?.转换() ?: null}")
            else -> println(log?.toString() ?: "null")
        }
    }

}