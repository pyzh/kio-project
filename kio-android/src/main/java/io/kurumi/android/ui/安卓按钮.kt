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

import android.widget.Button
import io.kurumi.app.content.上下文
import io.kurumi.app.ui.abs.按钮
import io.kurumi.app.ui.颜色

open class 安卓按钮(_上下文 : 上下文, override val 内容 :Button = Button(取上下文(_上下文))) : 安卓文本视图(_上下文,内容),按钮 {

    init {

        (this as 安卓文本视图).文本颜色 = 颜色.白色

    }

}