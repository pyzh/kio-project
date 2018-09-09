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

import javafx.scene.control.Label
import javafx.scene.text.Font

open class 桌面文本视图(_上下文: 上下文, override val 内容: Label) : 桌面视图(_上下文, 内容), 基本文本 {

    constructor(_上下文: 上下文) : this(_上下文, Label())

    override var 文本: String
        get() = 内容.text
        set(value) {
            内容.text = value
        }

    override var 文本颜色: Int
        get() = "#${内容.textFill}".toIntColor()
        set(value) {
            val lv = value.toLong()
            内容.textFill = value.toColor()
        }

    override var 文本大小: Int
        get() = 内容.font.size.toInt()
        set(value) {
            内容.font = Font.font(value.toDouble())
        }
}