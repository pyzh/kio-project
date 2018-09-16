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

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import io.kurumi.app.content.上下文
import io.kurumi.app.ui.abs.图片视图
import io.kurumi.core.文件

open class 安卓图片视图(_上下文: 上下文, override val 内容: ImageView = ImageView(取上下文(_上下文))) : 安卓视图(_上下文, 内容), 图片视图 {

    override fun 图片(_地址: String) {
        Glide.with(内容).load(_地址).into(内容)
    }

    fun 长度(_长度 : Int) :Int {
        if (_长度 == -2) return Integer.MIN_VALUE
        else if (_长度 == -1) return Integer.MAX_VALUE
        else return _长度
    }

    override fun 图片(_地址: String, _宽度: Int, _高度: Int) {
        Glide.with(内容)
                .load(_地址)
                .apply(RequestOptions().apply {
                    override(长度(_宽度),长度(_高度))
                })
                .into(内容)
    }

    override fun 图片(_文件: 文件) {
        Glide.with(内容).load(_文件.文件).into(内容)
    }

    override fun 图片(_文件: 文件, _宽度: Int, _高度: Int) {
        Glide.with(内容)
                .load(_文件.文件)
                .apply(RequestOptions().apply {
                    override(长度(_宽度),长度(_高度))
                })
                .into(内容)
    }
}