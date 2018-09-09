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

package io.kurumi.jvm

import io.kurumi.app.content.基本界面
import io.kurumi.app.content.界面
import io.kurumi.app.ui.abs.布局
import io.kurumi.app.ui.abs.文本视图
import io.kurumi.app.ui.abs.线性布局
import io.kurumi.app.ui.abs.视图
import javafx.stage.Stage
import kotlin.reflect.KClass

class 桌面界面 : Stage(), 基本界面 {

    override fun 显示() {
        show()
    }

    override fun 关闭() {
        hide()
    }

    override var 标题: String
        get() = title
        set(value) {}

    override var 内容: 视图?
        get() = TODO()
        set(value) {}

    override fun 子界面(_界面: KClass<out 界面>) {
        TODO()
    }

    override fun 视图(): 视图 {
        TODO()
    }

    override fun 布局(): 布局 {
        TODO()
    }

    override fun 垂直布局(): 线性布局 {
        TODO()
    }

    override fun 水平布局(): 线性布局 {
        TODO()
    }

    override fun 文本视图(): 文本视图 {
        TODO()
    }
}