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
import kotlin.reflect.KClass

object 桌面应用测试 : 桌面应用() {

    @JvmStatic
    fun main(args: Array<String>) {
        启动(args)
    }

    override val 应用: KClass<out 应用> get() = App::class

    class App : 应用 {

        override fun 应用启动事件() {

            测试界面::class.启动()

        }

    }


}
