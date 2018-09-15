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

import android.view.ViewGroup
import android.widget.LinearLayout
import io.kurumi.app.content.上下文
import io.kurumi.app.ui.abs.布局
import io.kurumi.app.ui.abs.视图
import io.kurumi.主线程

open class 安卓布局(_上下文: 上下文, override val 内容: ViewGroup = LinearLayout(取上下文(_上下文))) : 安卓视图(_上下文, 内容), 布局 {

    override fun 加入子视图(vararg _视图: 视图) {
        主线程 {
            _视图.forEach {
                内容.addView((it as 安卓视图).内容)
            }
        }
    }

    override fun 删子视图(_视图: 视图) {
        主线程 {
            内容.removeView((_视图 as 安卓视图).内容)
        }
    }

    override fun 取子视图(_键值: Int): 视图? {
        return 内容.getChildAt(_键值) as 视图?
    }

}