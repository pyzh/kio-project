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

package io.kurumi.android.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import io.kurumi.android.R
import io.kurumi.android.安卓应用
import io.kurumi.android.系统服务
import io.kurumi.app.content.上下文
import io.kurumi.app.ui.abs.视图
import io.kurumi.主线程

open class 安卓视图(override val 上下文: 上下文, open val 内容: View = View(取上下文(上下文))) : 视图 {

    var params: ViewGroup.LayoutParams
        get() {
            var f = 内容.layoutParams
            if (f == null) {
                f = ViewGroup.LayoutParams(-2, -2)
                params = f
            }
            return f
        }
        set(value) {
            主线程 {
                内容.layoutParams = value
            }
        }

    override var 宽度: Int
        get() = params.width
        set(value) {
            params.width = value
            params = params
        }

    override var 高度: Int
        get() = params.height
        set(value) {
            params.height = value
            params = params
        }

    override var 宽高: Int
        get() = -1
        set(value) {
            宽度 = value
            高度 = value
        }

    override var 上填充: Int
        get() = dpx(内容.paddingTop)
        set(value) {
            置填充(value, 下填充, 左填充, 右填充)
        }

    override var 下填充: Int
        get() = dpx(内容.paddingBottom)
        set(value) {
            置填充(上填充, value, 左填充, 右填充)
        }

    override var 左填充: Int
        get() = dpx(内容.paddingLeft)
        set(value) {
            置填充(上填充, 下填充, value, 右填充)
        }

    override var 右填充: Int
        get() = dpx(内容.paddingRight)
        set(value) {
            置填充(上填充, 下填充, 左填充, value)
        }

    override var 填充: Int
        get() = -1
        set(value) {
            置填充(value, value, value, value)
        }

    override fun 置填充(_上: Int, _下: Int, _左: Int, _右: Int) {
        主线程 {
            内容.setPadding(dp(_左), dp(_上), dp(_右), dp(_下))
        }
    }

    override var 显示: Boolean
        get() = 内容.visibility == View.VISIBLE
        set(value) {
            主线程 {
                内容.visibility = if (value) View.VISIBLE else View.GONE
            }
        }

    override fun 单击事件(_事件: () -> Unit) {
        内容.setOnClickListener {
            _事件()
        }
    }

    override fun 附加事件(_事件: () -> Unit) {
        内容.setOnLongClickListener {
            _事件()
            true
        }
    }

    override var 背景颜色: Int
        get() = -1
        set(value) {
            内容.setBackgroundColor(value)
        }

    override var 阴影: Int
        get() = dpx(内容.translationZ)
        set(value) {
            内容.translationZ = dp(value).toFloat()
        }

    companion object {

        fun 取上下文(_上下文: 上下文): Context {
            if (_上下文 is Context) return _上下文
            return 安卓应用.实例
        }

        fun dpx(dimen: Number): Int {
            return (dimen.toFloat() / 系统服务.屏幕信息.density).toInt()
        }

        fun spx(dimen: Number): Int {
            return ((dimen.toFloat() / 系统服务.屏幕信息.scaledDensity) * 系统服务.屏幕信息.density).toInt()
        }

        fun dp(dimen: Int): Int {
            return (dimen.toFloat() * 系统服务.屏幕信息.density).toInt()
        }

        fun sp(dimen: Int): Int {
            return ((dimen.toFloat() * 系统服务.屏幕信息.scaledDensity) / 系统服务.屏幕信息.density).toInt()
        }

    }

}