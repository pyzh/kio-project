package io.kurumi.desktop.ui

import io.kurumi.platform.ui.布局重力
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