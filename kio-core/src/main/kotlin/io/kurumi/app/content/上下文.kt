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

package io.kurumi.app.content

import io.kurumi.app.ui.abs.*

/**
 * 提供UI显示的接口 多个实现(android/javafx/html等)
 */
interface 上下文 {

    // --------------  视图 ---------------------

    fun 视图(): 视图

    fun 布局(): 布局

    fun 垂直布局(): 线性布局

    fun 水平布局(): 线性布局

    fun 文本视图(): 文本视图

    fun 按钮(): 按钮

    fun 图片视图(): 图片视图

    fun 编辑框() : 编辑框

}