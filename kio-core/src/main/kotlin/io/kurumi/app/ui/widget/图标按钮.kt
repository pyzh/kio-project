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

import io.kurumi.app.content.上下文
import io.kurumi.app.ui.abs.图片视图
import io.kurumi.app.ui.abs.布局
import io.kurumi.app.ui.abs.线性布局
import io.kurumi.app.ui.布局重力
import io.kurumi.app.ui.颜色
import io.kurumi.core.文件

internal interface 图标按钮 : 线性布局, 图片视图

internal fun 上下文.图标按钮(): 图标按钮 {

    return object : 图标按钮, 线性布局 by 水平布局() {

        private val 图片 = 图片视图 {

            宽高 = 22

        }

        init {

            宽高 = 56

            重力 = 布局重力.中间

            背景颜色 = 颜色.透明

        }

        override fun 图片(_地址: String) = 图片.图片(_地址)

        override fun 图片(_地址: String, _宽度: Int, _高度: Int) = 图片.图片(_地址, _宽度, _高度)

        override fun 图片(_文件: 文件) = 图片.图片(_文件)

        override fun 图片(_文件: 文件, _宽度: Int, _高度: Int) = 图片.图片(_文件, _宽度, _高度)

    }

}

internal fun 上下文.图标按钮(_初始化: (图标按钮.() -> Unit)) = 图标按钮().apply(_初始化)

internal fun 布局.图标按钮() = 上下文.图标按钮().also { 子视图.add(it) }

internal fun 布局.图标按钮(_初始化: (图标按钮.() -> Unit)) = 图标按钮().apply(_初始化)