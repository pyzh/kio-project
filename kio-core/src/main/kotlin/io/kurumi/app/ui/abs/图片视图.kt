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

interface 图片视图 : 视图 {

    fun 图片(_地址 : String)
    fun 图片(_地址 : String,_宽度 : Int,_高度 : Int)
    fun 图片(_文件 : 文件)
    fun 图片(_文件: 文件,_宽度 : Int,_高度 : Int)

}


fun 上下文.图片视图(_初始化: (图片视图.() -> Unit)) = 图片视图().apply(_初始化)

fun 布局.图片视图(_初始化: (图片视图.() -> Unit)) = 上下文.图片视图().also {
    子视图.add(it)
}.apply(_初始化)

// add path param

fun 上下文.图片视图(_图片地址: String) = 图片视图().apply {
    图片(_图片地址)
}

fun 上下文.图片视图(_图片地址: String, _初始化: (图片视图.() -> Unit)) = 图片视图(_图片地址).apply(_初始化)

fun 布局.图片视图(_图片地址: String) = 图片视图 {
    图片(_图片地址)
}

fun 布局.图片视图(_图片地址: String,_初始化: 图片视图.() -> Unit) = 图片视图(_图片地址).apply(_初始化)