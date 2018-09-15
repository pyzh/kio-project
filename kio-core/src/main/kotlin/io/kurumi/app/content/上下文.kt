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

import io.kurumi.app.ui.abs.*

/**
 * 提供UI显示的接口 多个实现(android/javafx/html等)
 */
interface 上下文 {

    // --------------  视图 ---------------------

    fun 视图(): 视图

    fun 视图(_初始化: (视图.() -> Unit)): 视图 = 视图().apply(_初始化)

    fun 布局.视图(): 视图 = 视图()

    fun 布局.视图(_初始化: (视图.() -> Unit)): 视图 = this@上下文.视图(_初始化).also {
        子视图.add(it)
    }

    // --------------  布局 ---------------------

    fun 布局(): 布局

    fun 布局(_初始化: (布局.() -> Unit)): 布局 = 布局().apply(_初始化)

    fun 布局.布局(): 布局 = 布局()

    fun 布局.布局(_初始化: (布局.() -> Unit)): 布局 = this@上下文.布局(_初始化).also {
        子视图.add(it)
    }

    // --------------  线性布局 -----------------

    fun 垂直布局(): 线性布局

    fun 垂直布局(_初始化: (线性布局.() -> Unit)): 线性布局 = 垂直布局().apply(_初始化)

    fun 布局.垂直布局(): 线性布局 = 垂直布局()

    fun 布局.垂直布局(_初始化: (线性布局.() -> Unit)): 线性布局 = this@上下文.垂直布局(_初始化).also {
        子视图.add(it)
    }

    fun 水平布局(): 线性布局

    fun 水平布局(_初始化: (线性布局.() -> Unit)): 线性布局 = 水平布局().apply(_初始化)

    fun 布局.水平布局(): 线性布局 = 水平布局()

    fun 布局.水平布局(_初始化: (线性布局.() -> Unit)): 线性布局 = this@上下文.水平布局(_初始化).also {
        子视图.add(it)
    }

    // --------------  文本视图 -----------------

    fun 文本视图(): 文本视图

    fun 文本视图(_初始化: (文本视图.() -> Unit)): 文本视图 = 文本视图().apply(_初始化)

    fun 布局.文本视图(): 文本视图 = 文本视图()

    fun 布局.文本视图(_初始化: (文本视图.() -> Unit)): 文本视图 = this@上下文.文本视图(_初始化).also {
        子视图.add(it)
    }

    // --------------  按钮 -----------------

    fun 按钮(): 按钮

    fun 按钮(_初始化: (按钮.() -> Unit)): 按钮 = 按钮().apply(_初始化)

    fun 布局.按钮(): 按钮 = 按钮()

    fun 布局.按钮(_初始化: (按钮.() -> Unit)): 按钮 = this@上下文.按钮(_初始化).also {
        子视图.add(it)
    }

}