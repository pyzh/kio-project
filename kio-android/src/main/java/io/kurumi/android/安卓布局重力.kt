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

package io.kurumi.android

import android.annotation.SuppressLint
import android.view.Gravity.*
import io.kurumi.app.ui.布局重力
import io.kurumi.app.ui.布局重力.*

object 安卓布局重力 {

    @SuppressLint("RtlHardcoded")
    fun 到重力(_重力: Int): 布局重力 {

        var center = false
        var left = false
        var right = false

        var top = false
        var bottom = false

        if (_重力 and FILL == FILL) {

        } else {
            if (_重力 and FILL_VERTICAL == FILL_VERTICAL) {
            } else {
                if (_重力 and TOP == TOP) {
                    top = true
                }
                if (_重力 and BOTTOM == BOTTOM) {
                    bottom = true
                }
            }
            if (_重力 and FILL_HORIZONTAL == FILL_HORIZONTAL) {
            } else {
                if (_重力 and START == START) {
                    left = true
                } else if (_重力 and LEFT == LEFT) {
                    left = true
                }
                if (_重力 and END == END) {
                    right = true
                } else if (_重力 and RIGHT == RIGHT) {
                    right = true
                }
            }
        }
        if (_重力 and CENTER == CENTER) {
            center = true
        } else {
            if (_重力 and CENTER_VERTICAL == CENTER_VERTICAL) {
                center = true
                left = true
            }
            if (_重力 and CENTER_HORIZONTAL == CENTER_HORIZONTAL) {
                center = true
                top = true
            }
        }

        return if (left) {
            if (center) 左中
            else if (bottom) 左下
            else 左上
        } else if (right) {
            if (center) 右中
            else if (bottom) 右下
            else 右上

        } else if (center) {
            if (center) 中间
            else if (bottom) 中下
            else 中上
        } else {
            if (bottom) 左下
            左上
        }

    }

    fun 到重力(_重力: 布局重力): Int {

        when (_重力) {

            左上 -> return START or TOP
            左中 -> return START or CENTER
            左下 -> return START or BOTTOM

            中上 -> return CENTER or TOP
            中间 -> return CENTER
            中下 -> return CENTER or BOTTOM

            右上 -> return END or TOP
            右中 -> return END or CENTER
            右下 -> return END or BOTTOM

        }

    }

}