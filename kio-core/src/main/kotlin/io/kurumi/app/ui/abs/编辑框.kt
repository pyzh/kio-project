/*
 * Copyright 2018 MikaGuraNTK
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.kurumi.app.ui.abs

import io.kurumi.app.content.上下文

interface 编辑框 : 文本视图 {

    var 默认文本: String
    var 默认文本颜色: Int

}


fun 上下文.编辑框(_初始化: (编辑框.() -> Unit)) = 编辑框().apply(_初始化)

fun 布局.编辑框() = 上下文.编辑框().also {
    子视图.add(it)
}

fun 布局.编辑框(_初始化: (编辑框.() -> Unit)) = 编辑框().apply(_初始化)

// add hint param

fun 上下文.编辑框(_默认文本: String) = 编辑框().apply {
    默认文本 = _默认文本
}

fun 上下文.编辑框(_默认文本: String, _初始化: (编辑框.() -> Unit)) = 编辑框(_默认文本).apply(_初始化)


fun 布局.编辑框(_默认文本: String) = 编辑框 {
    默认文本 = _默认文本
}

fun 布局.编辑框(_默认文本: String, _初始化: (文本视图.() -> Unit)) = 编辑框(_默认文本).apply(_初始化)
