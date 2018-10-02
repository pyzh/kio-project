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

package io.kurumi.demo.core

import io.kurumi.app.content.界面
import io.kurumi.app.ui.abs.*
import io.kurumi.util.提示

class 界面实例 : 界面() {

    override fun 界面创建事件() {

        标题 = "你好 世界"

        内容 = 垂直布局 {

            填充 = 16

            文本视图("你好 Kio!")

            边距布局(8)

            val 编辑框1 = 编辑框("输入什么? ")

            按钮("一个按钮 ~") {

                单击事件 {

                    提示("你输入了 : ${编辑框1.文本}")



                }

            }

        }
    }

}
