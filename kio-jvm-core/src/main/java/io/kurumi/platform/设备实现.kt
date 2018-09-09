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

package io.kurumi.platform

import io.kurumi.service.基本服务
import kotlin.reflect.KClass

open class 设备实现 {

    private val 所有服务 = HashMap<KClass<out 基本服务>, 基本服务>()

    fun 服务可用(_服务: KClass<out 基本服务>): Boolean {
        return 所有服务.containsKey(_服务)
    }

    fun 取服务(_服务: KClass<out 基本服务>): 基本服务? {
        return 所有服务.get(_服务)
    }

    fun <服务 : 基本服务> 注册服务(_服务: KClass<服务>, _实现: 服务) {
        所有服务.put(_服务, _实现)
    }

}