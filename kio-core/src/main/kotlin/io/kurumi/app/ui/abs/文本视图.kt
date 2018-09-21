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
import io.kurumi.core.文件

interface 文本视图 : 视图 {

    var 文本: String
    var 文本颜色: Int
    var 文本大小: Int
    var 单行: Boolean
    var 最大行数: Int
    var 最大字数: Int

    fun 字体(_地址: String) = 字体(文件.取实例(_地址))
    fun 字体(_字体: 文件)

}

fun 上下文.文本视图(_初始化: (文本视图.() -> Unit)) = 文本视图().apply(_初始化)

fun 布局.文本视图() = 上下文.文本视图().also {
    子视图.add(it)
}

fun 布局.文本视图(_初始化: (文本视图.() -> Unit)) = 文本视图().apply(_初始化)

// add text param

fun 上下文.文本视图(_文本: String) = 文本视图().apply {
    文本 = _文本
}

fun 上下文.文本视图(_文本: String, _初始化: (文本视图.() -> Unit)) = 文本视图(_文本).apply(_初始化)


fun 布局.文本视图(_文本: String) = 文本视图 {

    文本 = _文本

}

fun 布局.文本视图(_文本: String,_初始化: (文本视图.() -> Unit)) = 文本视图(_文本).apply(_初始化)
