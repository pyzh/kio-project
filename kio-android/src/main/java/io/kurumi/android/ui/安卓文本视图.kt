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

import android.graphics.Typeface
import android.widget.TextView
import cn.hutool.core.util.ReflectUtil
import io.kurumi.app.content.上下文
import io.kurumi.app.ui.abs.文本视图
import io.kurumi.core.文件
import io.kurumi.主线程

open class 安卓文本视图(_上下文: 上下文, override val 内容: TextView = TextView(取上下文(_上下文))) : 安卓视图(_上下文, 内容), 文本视图 {

    override var 文本: String
        get() = 内容.text.toString() ?: ""
        set(value) {
            主线程 {
                内容.text = value
            }
        }

    override var 文本颜色: Int
        get() = 内容.currentTextColor
        set(value) {
            主线程 {
                内容.setTextColor(value)
            }
        }

    override var 文本大小: Int
        get() = spx(内容.textSize)
        set(value) {
            主线程 {
                内容.textSize = sp(value).toFloat()
            }
        }

    val mSingleLineField by lazy {
        ReflectUtil.getField(TextView::class.java, "mSingleLine")
    }

    override var 单行: Boolean
        get() {
            return mSingleLineField.get(内容) as Boolean? ?: false
        }
        set(value) {
            主线程 {
                内容.setSingleLine(value)
            }
        }

    override var 最大行数: Int
        get() = 内容.maxLines
        set(value) {
            主线程 {
                内容.maxLines = value
            }
        }

    override var 最大字数: Int
        get() = 内容.maxEms
        set(value) {
            内容.maxEms = value
        }

    override fun 字体(_字体: 文件) {
        内容.typeface = Typeface.createFromFile(_字体.文件)
    }

}