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

interface 按钮 : 文本视图 {
}


fun 上下文.按钮(_初始化: (按钮.() -> Unit)) = 按钮().apply(_初始化)

fun 布局.按钮() = 上下文.按钮().also {
    子视图.add(it)
}

fun 布局.按钮(_初始化: (按钮.() -> Unit)) = 按钮().apply(_初始化)

// add text param

fun 上下文.按钮(_文本: String) = 按钮().apply {
    文本 = _文本
}

fun 上下文.按钮(_文本: String, _初始化: (按钮.() -> Unit)) = 按钮(_文本).apply(_初始化)


fun 布局.按钮(_文本: String) = 按钮 {
    文本 = _文本
}

fun 布局.按钮(_文本: String,_初始化: (按钮.() -> Unit)) = 按钮(_文本).apply(_初始化)
