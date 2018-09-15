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

package io.kurumi.android.ui

import android.os.Build
import android.widget.LinearLayout
import cn.hutool.core.util.ReflectUtil
import io.kurumi.android.安卓布局重力
import io.kurumi.app.content.上下文
import io.kurumi.app.ui.abs.线性布局
import io.kurumi.app.ui.布局方向
import io.kurumi.app.ui.布局重力
import io.kurumi.主线程

abstract class 安卓线性布局(_上下文: 上下文, override val 内容: LinearLayout = LinearLayout(取上下文(_上下文))) : 安卓布局(_上下文, 内容), 线性布局 {

    val gravityRef: Int
        get() {
            return ReflectUtil.getFieldValue(内容, "mGravity") as Int
        }

    override var 重力: 布局重力
        get() {
            return 安卓布局重力.到重力(if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                内容.gravity
            } else {
                gravityRef
            })
        }
        set(value) {
            主线程 {
                内容.gravity = 安卓布局重力.到重力(value)
            }
        }

    companion object {

        fun 到方向(_方向: 布局方向): Int {
            return when (_方向) {
                布局方向.水平 -> LinearLayout.HORIZONTAL
                布局方向.垂直 -> LinearLayout.VERTICAL
            }
        }

        fun 到方向(_方向: Int): 布局方向 {
            return when (_方向) {
                LinearLayout.HORIZONTAL -> 布局方向.水平
                LinearLayout.VERTICAL -> 布局方向.垂直
                else -> error("无效的安卓布局方向 : _方向")
            }
        }

    }

    open class 垂直(_上下文: 上下文) : 安卓线性布局(_上下文), 线性布局.垂直 {
        init {
            内容.orientation = 到方向(布局方向.垂直)
        }
    }

    open class 水平(_上下文: 上下文) : 安卓线性布局(_上下文), 线性布局.水平 {
        init {
            内容.orientation = 到方向(布局方向.水平)
        }
    }

}