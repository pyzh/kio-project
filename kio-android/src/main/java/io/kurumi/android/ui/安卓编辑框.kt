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

import android.widget.EditText
import io.kurumi.app.content.上下文
import io.kurumi.app.ui.abs.编辑框

open class 安卓编辑框(_上下文: 上下文, override val 内容: EditText = EditText(取上下文(_上下文))) : 安卓文本视图(_上下文, 内容), 编辑框 {

    override var 默认文本: String
        get() = 内容.hint.toString()
        set(value) {
            内容.hint = value
        }

    override var 默认文本颜色: Int
        get() = 内容.currentHintTextColor
        set(value) {
            内容.setHintTextColor(value)
        }

}