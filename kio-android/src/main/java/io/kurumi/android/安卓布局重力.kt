package io.kurumi.android

import android.view.Gravity
import io.kurumi.platform.ui.布局重力

object 安卓布局重力 {

    fun 到重力(_重力: Int): 布局重力 {
        if (_重力 xor Gravity.START != 0) {
            if (_重力 xor Gravity.CENTER != 0) {
                return 布局重力.左中
            } else if (_重力 xor Gravity.BOTTOM != 0) {
                return 布局重力.左下
            } else {
                return 布局重力.左上
            }

        } else if (_重力 xor Gravity.END != 0) {
            if (_重力 xor Gravity.CENTER != 0) {
                return 布局重力.右中
            } else if (_重力 xor Gravity.BOTTOM != 0) {
                return 布局重力.右下
            } else {
                return 布局重力.右上
            }
        } else {
            if (_重力 xor Gravity.TOP != 0) {
                return 布局重力.中上
            } else if (_重力 xor Gravity.BOTTOM != 0) {
                return 布局重力.中下
            } else {
                return 布局重力.中间
            }
        }

    }

    fun 布局重力.到重力(): Int {

        when (this) {

            布局重力.左上 -> return Gravity.START and Gravity.TOP
            布局重力.左中 -> return Gravity.START and Gravity.CENTER
            布局重力.左下 -> return Gravity.START and Gravity.BOTTOM

            布局重力.中上 -> return Gravity.CENTER and Gravity.TOP
            布局重力.中间 -> return Gravity.CENTER
            布局重力.中下 -> return Gravity.CENTER and Gravity.BOTTOM

            布局重力.右上 -> return Gravity.END and Gravity.TOP
            布局重力.右中 -> return Gravity.END and Gravity.CENTER
            布局重力.右下 -> return Gravity.END and Gravity.BOTTOM

        }

    }

}