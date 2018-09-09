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

package io.kurumi.desktop.ui.view

import io.kurumi.desktop.ui.桌面重力
import io.kurumi.app.content.上下文
import io.kurumi.app.ui.abs.线性布局
import io.kurumi.app.ui.布局方向
import io.kurumi.app.ui.布局重力
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

abstract class 桌面线性布局 : 桌面布局, 线性布局 {

    constructor(_上下文: 上下文, _视图: HBox) : super(_上下文, _视图)
    constructor(_上下文: 上下文, _视图: VBox) : super(_上下文, _视图)

    override var 重力: 布局重力
        get() {
            return when (方向) {
                布局方向.垂直 -> {
                    桌面重力.方向到重力((内容 as VBox).alignment)
                }
                布局方向.水平 -> {
                    桌面重力.方向到重力((内容 as HBox).alignment)
                }
            }
        }
        set(value) {
            when (方向) {
                布局方向.垂直 -> {
                    (内容 as VBox).alignment = 桌面重力.重力到方向(value)
                }
                布局方向.水平 -> {
                    (内容 as HBox).alignment = 桌面重力.重力到方向(value)
                }
            }
        }

    open class 垂直(_上下文: 上下文, override val 内容: VBox = VBox()) : 桌面线性布局(_上下文, 内容), 线性布局.垂直
    open class 水平(_上下文: 上下文, override val 内容: HBox = HBox()) : 桌面线性布局(_上下文, 内容), 线性布局.水平

}