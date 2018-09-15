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

package io.kurumi.util

import android.util.Log
import android.view.Gravity
import android.widget.CardView
import android.widget.TextView
import android.widget.Toast
import io.kurumi.android.ui.安卓视图
import io.kurumi.android.安卓应用
import io.kurumi.app.ui.颜色

actual interface 日志 {

    actual fun 调试(_内容: String)
    actual fun 提示(_内容: String)
    actual fun 警告(_内容: String)

    actual companion object : 日志 {

        override fun 调试(_内容: String) {
            Log.i("KioLog", _内容)
        }

        override fun 提示(_内容: String) {
            printMsg(_内容, 颜色.基本.基本)
        }

        override fun 警告(_内容: String) {
            printMsg(_内容, 颜色.红色.基本)
        }

        fun printMsg(log: Any?, color: Int) {

            val card = CardView(安卓应用.实例)
            card.setCardBackgroundColor(颜色.白色)

            val padding = 安卓视图.dp(8)
            card.setPadding(padding, padding, padding, padding)

            card.gravity = Gravity.CENTER

            val text = TextView(安卓应用.实例)
            text.text = log?.toString() ?: "null"
            text.setTextColor(color)
            text.textSize = 安卓视图.sp(14).toFloat()

            card.addView(text)

            val toast = Toast.makeText(安卓应用.实例, log?.toString() ?: "null", Toast.LENGTH_SHORT)
            toast.view = card
            toast.show()

        }

    }

}