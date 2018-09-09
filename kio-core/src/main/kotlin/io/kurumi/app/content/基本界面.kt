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

package io.kurumi.app.content

import io.kurumi.app.ui.abs.视图
import kotlin.reflect.KClass

interface 基本界面 : 上下文 {

    fun 显示()
    fun 关闭()

    var 标题: String
    var 内容: 视图?

    fun 子界面(_界面: KClass<out 界面>)

}