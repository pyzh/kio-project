package io.kurumi.android.service

import android.util.Log
import android.view.Gravity
import android.widget.CardView
import android.widget.TextView
import android.widget.Toast
import io.kurumi.android.ui.安卓视图
import io.kurumi.android.安卓应用


object 安卓日志服务 : 日志服务 {

    override fun 打印(level: 日志服务.Level, log: Any?) {

        when (level) {
            日志服务.Level.Debug -> Log.d(CallerUtil.getCaller(2).toString(), log?.toString() ?: "null")
            日志服务.Level.Info -> printMsg(log, 颜色.当前颜色.基本)
            日志服务.Level.Warning -> printMsg(log, 颜色.红色.基本)
            日志服务.Level.Error -> {
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