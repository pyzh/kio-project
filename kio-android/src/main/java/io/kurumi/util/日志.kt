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

package io.kurumi.util

import android.util.Log
import android.view.Gravity
import android.widget.CardView
import android.widget.TextView
import android.widget.Toast
import cn.hutool.core.lang.caller.CallerUtil
import io.kurumi.android.ui.安卓视图
import io.kurumi.android.安卓应用
import io.kurumi.app.ui.颜色

actual object 默认 : 基本日志 {

    override fun 打印(level: 基本日志.等级, log: Any?) {

        when (level) {
            基本日志.等级.Debug -> Log.d(CallerUtil.getCaller(2).toString(), log?.toString() ?: "null")
            基本日志.等级.Info -> printMsg(log, 颜色.基本.基本)
            基本日志.等级.Warning -> printMsg(log, 颜色.红色.基本)
            基本日志.等级.Error -> {
                printMsg(log, 颜色.红色.基本)
                Log.e(CallerUtil.getCaller(2).toString(), log?.toString() ?: "null")
            }
        }

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