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

package io.kurumi.app.ui.abs

import io.kurumi.app.content.上下文
import io.kurumi.dsl.领域上下文

/**
 * 基本视图对象
 * 大小在android中为转换成dp
 * 字体大小在android中装换成sp
 */
@领域上下文
interface 视图 {

    val 上下文: 上下文

    var 宽度: Int
    var 高度: Int

    var 宽高: Int

    var 上填充: Int
    var 下填充: Int
    var 左填充: Int
    var 右填充: Int
    var 填充: Int

    var 背景颜色: Int

    var 显示: Boolean

    var 阴影: Int

    fun 单击事件(_事件 : () -> Unit)
    fun 附加事件(_事件 : () -> Unit)


    fun 置填充(_上: Int, _下: Int, _左: Int, _右: Int)

}