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

package io.kurumi.app.ui.widget

import io.kurumi.app.content.上下文
import io.kurumi.app.ui.abs.垂直布局
import io.kurumi.app.ui.abs.文本视图
import io.kurumi.app.ui.abs.线性布局
import io.kurumi.core.文件
import 图标按钮

interface 标题栏 : 线性布局, 文本视图 {

    fun 导航按钮(_图标: String)

}

fun 上下文.标题栏(): 标题栏 {

    return object : 标题栏, 线性布局 by 水平布局() {

        val 导航按钮 = 图标按钮 { 隐藏() }

        val 标题布局 = 垂直布局 {}

        val 标题 = 标题布局.文本视图()

        override var 文本: String
            get() = 标题.文本
            set(value) {
                标题.文本 = value
            }

        override var 文本颜色: Int
            get() = 标题.文本颜色
            set(value) {
                标题.文本颜色 = value
            }

        override var 文本大小: Int
            get() = 标题.文本大小
            set(value) {
                标题.文本大小 = value
            }

        override var 单行: Boolean
            get() = 标题.单行
            set(value) {
                标题.单行 = value
            }

        override var 最大行数: Int
            get() = 标题.最大行数
            set(value) {
                标题.最大行数 = value
            }

        override var 最大字数: Int
            get() = 标题.最大字数
            set(value) {
                标题.最大字数 = value
            }

        override fun 字体(_字体: 文件) {
            标题.字体(_字体)
        }

        init {
            阴影 = 4
        }

        override fun 导航按钮(_图标: String) {

            导航按钮.显示()
            导航按钮.图片(_图标)

        }
    }

}