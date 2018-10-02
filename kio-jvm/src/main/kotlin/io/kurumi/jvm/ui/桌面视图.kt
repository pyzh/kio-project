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

package io.kurumi.jvm.ui

import io.kurumi.app.content.上下文
import io.kurumi.app.ui.abs.视图
import io.kurumi.app.ui.布局重力
import javafx.geometry.Insets
import javafx.scene.Parent
import javafx.scene.layout.HBox
import javafx.scene.layout.Region
import javafx.scene.layout.VBox

open class 桌面视图(override val 上下文: 上下文, open val 内容: Region) : 视图 {

    override var 宽度: Int
        get() = 内容.width.toInt()
        set(value) {
            内容.prefWidth = value.toDouble()
        }

    override var 高度: Int
        get() = 内容.height.toInt()
        set(value) {
            内容.prefHeight = value.toDouble()
        }

    override var 宽高: Int
        get() = -1
        set(value) {
            宽度 = value
            高度 = value
        }

    private val linparent: Parent
        get() {
            val lp: Parent? = 内容.parent
            if (lp == null || (lp !is HBox || lp !is VBox)) {
                error("没有加入到线性布局")
            }
        }

    override var 上填充: Int
        get() = padd
        set(value) {}

    override var 下填充: Int
        get() = TODO()
        set(value) {}

    override var 左填充: Int
        get() = TODO()
        set(value) {}
    override var 右填充: Int
        get() = TODO()
        set(value) {}

    override var 填充: Int
        get() = TODO()
        set(value) {}

    override var 上边距: Int
        get() = TODO()
        set(value) {}

    override var 下边距: Int
        get() = TODO()
        set(value) {}
    override var 左边距: Int
        get() = TODO()
        set(value) {}
    override var 右边距: Int
        get() = TODO()
        set(value) {}
    override var 边距: Int
        get() = TODO()
        set(value) {}
    override var 背景颜色: Int
        get() = TODO()
        set(value) {}
    override var 显示: Boolean
        get() = TODO()
        set(value) {}
    override var 阴影: Int
        get() = TODO()
        set(value) {}

    override fun 单击事件(_事件: () -> Unit) {
        TODO()
    }

    override fun 附加事件(_事件: () -> Unit) {
        TODO()
    }

    override var 布局内重力: 布局重力
        get() = TODO()
        set(value) {}

    override var 布局内权重: Float
        get() = TODO()
        set(value) {}

    override fun 置填充(_上: Int, _下: Int, _左: Int, _右: Int) {
        内容.padding = Insets(_左.toDouble() ,_上.toDouble(),_右.toDouble(),_下.toDouble())
    }

    override fun 置边距(_上: Int, _下: Int, _左: Int, _右: Int) {
        TODO()
    }
}