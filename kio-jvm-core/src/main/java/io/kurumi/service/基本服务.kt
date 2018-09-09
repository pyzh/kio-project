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

import io.kurumi.platform.设备
import kotlin.reflect.KClass

interface 基本服务 {
}

val <服务 : 基本服务> KClass<服务>.实现: 服务
    get() {
        if (!设备.服务可用(this)) {
            error("服务 : ${java.simpleName} 不可用")
        }
        return 设备.取服务(this)
    }