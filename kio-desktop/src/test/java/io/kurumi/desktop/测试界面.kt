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

package io.kurumi.desktop

import io.kurumi.app.content.界面
import io.kurumi.app.ui.view.垂直布局
import io.kurumi.app.ui.view.文本视图

class 测试界面 : 界面() {

    override fun 界面创建事件() {

        标题 = "Hello Kio"

        内容 = 垂直布局 {

            填充 = 16

            val 文本 = 文本视图 {

                文本 = "你好 世界 !"

            }

        }

    }
}