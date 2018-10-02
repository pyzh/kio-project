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

package io.kurumi.app.content

import io.kurumi.app.ui.abs.*
import kotlin.reflect.KClass

open class 界面 : 上下文,基本界面 {

    lateinit var 实现: 基本界面

    override fun 显示() {
        实现.显示()
    }

    override fun 关闭() {
        实现.关闭()
    }

    override fun 应用颜色() {
        实现.应用颜色()
    }

    override var 标题: String
        get() = 实现.标题
        set(value) {
            实现.标题 = value
        }

    override var 内容: 视图?
        get() = 实现.内容
        set(value) {
            实现.内容 = value
        }

    override fun 子界面(_界面: KClass<out 界面>) {
        实现.子界面(_界面)
    }

    override fun 视图(): 视图 = 实现.视图()

    override fun 布局(): 布局 = 实现.布局()

    override fun 垂直布局(): 线性布局 = 实现.垂直布局()

    override fun 水平布局(): 线性布局 = 实现.水平布局()

    override fun 文本视图(): 文本视图 = 实现.文本视图()

    override fun 按钮(): 按钮 = 实现.按钮()

    override fun 图片视图(): 图片视图 = 实现.图片视图()

    override fun 编辑框(): 编辑框 = 实现.编辑框()

    private var _界面创建事件 :() -> Unit = {}
    private var _界面销毁事件 :() -> Unit = {}

    open fun 界面创建事件() {
        _界面创建事件()
    }

    fun 界面创建事件(_覆盖 : () -> Unit) {
        _界面创建事件 = _覆盖
    }

    open fun 界面销毁事件() {
        _界面销毁事件()
    }

    fun 界面销毁事件(_覆盖 : () -> Unit) {
        _界面销毁事件 = _覆盖
    }


}