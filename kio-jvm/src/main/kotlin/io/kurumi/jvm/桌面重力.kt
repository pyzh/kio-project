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

package io.kurumi.desktop.ui

import io.kurumi.app.ui.布局重力
import javafx.geometry.Pos

object 桌面重力 {

    fun 重力到方向(_重力: 布局重力): Pos {

        when (_重力) {

            布局重力.左上 -> return Pos.TOP_LEFT
            布局重力.左中 -> return Pos.CENTER_LEFT
            布局重力.左下 -> return Pos.BOTTOM_LEFT

            布局重力.中上 -> return Pos.TOP_CENTER
            布局重力.中间 -> return Pos.CENTER
            布局重力.中下 -> return Pos.BOTTOM_CENTER

            布局重力.右上 -> return Pos.TOP_RIGHT
            布局重力.右中 -> return Pos.CENTER_RIGHT
            布局重力.右下 -> return Pos.BOTTOM_RIGHT
        }


    }

    fun 方向到重力(_方向: Pos): 布局重力 {

        when (_方向) {
            Pos.TOP_LEFT, Pos.BASELINE_LEFT -> return 布局重力.左上
            Pos.CENTER_LEFT -> return 布局重力.左中
            Pos.BOTTOM_LEFT -> return 布局重力.左下

            Pos.TOP_CENTER, Pos.BASELINE_CENTER -> return 布局重力.中上
            Pos.CENTER -> return 布局重力.中间
            Pos.BOTTOM_CENTER -> return 布局重力.中下

            Pos.TOP_RIGHT, Pos.BASELINE_RIGHT -> return 布局重力.右上
            Pos.CENTER_RIGHT -> return 布局重力.右中
            Pos.BOTTOM_RIGHT -> return 布局重力.右下
        }


    }

}