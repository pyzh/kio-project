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

import io.kurumi.app.content.应用
import io.kurumi.platform.设备
import io.kurumi.util.主线程
import kotlin.reflect.KClass

abstract class 桌面应用 {

    init {
        设备.初始化实现(桌面实现)
    }

    fun 启动(args: Array<String>) {

        val ra = 应用.java.newInstance() as 应用

        主线程 { ra.应用启动事件() }

    }

    abstract val 应用: KClass<out 应用>

}
