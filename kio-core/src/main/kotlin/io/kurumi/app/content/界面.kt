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

import io.kurumi.app.ui.abs.布局
import io.kurumi.app.ui.abs.文本视图
import io.kurumi.app.ui.abs.线性布局
import io.kurumi.app.ui.abs.视图

open class 界面 : 上下文 {

    lateinit var 实现: 基本界面

    override fun 视图(): 视图 = 实现.视图()

    override fun 布局(): 布局 = 实现.布局()

    override fun 垂直布局(): 线性布局 = 实现.垂直布局()

    override fun 水平布局(): 线性布局 = 实现.水平布局()

    override fun 文本视图(): 文本视图 = 实现.文本视图()

    open var 界面创建事件 = {}

    open var 界面销毁事件 = {}

}