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
import io.kurumi.app.ui.布局方向
import io.kurumi.app.ui.布局重力

interface 线性布局 : 布局 {

    val 方向: 布局方向
    var 重力: 布局重力

    interface 水平 : 线性布局 {
        override val 方向: 布局方向 get() = 布局方向.水平
    }

    interface 垂直 : 线性布局 {
        override val 方向: 布局方向 get() = 布局方向.垂直
    }

}


fun 上下文.垂直布局(_初始化: (线性布局.() -> Unit)): 线性布局 = 垂直布局().apply(_初始化)

fun 布局.垂直布局(): 线性布局 = 上下文.垂直布局().also {
    子视图.add(it)
}

fun 布局.垂直布局(_初始化: (线性布局.() -> Unit)) = 垂直布局().apply(_初始化)

fun 上下文.水平布局(_初始化: (线性布局.() -> Unit)) = 水平布局().apply(_初始化)

fun 布局.水平布局(): 线性布局 = 上下文.水平布局().also {
    子视图.add(it)
}

fun 布局.水平布局(_初始化: (线性布局.() -> Unit)) = 水平布局().apply(_初始化)

fun 布局.边距布局(_边距: Int): 线性布局 {
    return if (this is 线性布局 && 方向 == 布局方向.水平) {
        水平布局 {
            左边距 = _边距
        }
    } else 垂直布局 {
        上边距 = _边距
    }

}

fun 布局.边距布局(_边距: Int, _初始化: (线性布局.() -> Unit)) = 边距布局(_边距).apply(_初始化)