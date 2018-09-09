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

package io.kurumi.app.ui.abs

import io.kurumi.data.数据
import io.kurumi.data.数据列表

interface 布局 : 视图 {

    var 子视图: MutableList<视图>
        get() {
            return 数据列表<视图>().apply {
                监听器.add(object : 数据.监听器<视图> {
                    override fun 添加(_内容: Collection<视图>) {
                        _内容.forEach {
                            加入子视图(it)
                        }
                    }

                    override fun 删除(_内容: Collection<视图>) {
                        _内容.forEach {
                            删子视图(it)
                        }
                    }
                })
            }
        }
        set(_子视图: MutableList<视图>) {

            子视图.clear()
            子视图.addAll(_子视图)

        }

    fun 加入子视图(vararg _视图: 视图)

    fun 取子视图(_键值: Int): 视图? = if (子视图.size > _键值) 子视图[_键值] else null

    fun 删子视图(_视图: 视图)

    fun 删子视图(_键值: Int): 视图? = 子视图.removeAt(_键值)

}