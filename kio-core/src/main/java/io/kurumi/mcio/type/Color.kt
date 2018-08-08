package io.kurumi.mcio.type

import cn.hutool.core.util.StrUtil

enum class Color(val id: String) {

    Black("black"),
    DarkBlue("dark_blue"),
    DarkGreen("dark_green"),
    DarkAqua("dark_aqua"),
    DarkRed("dark_red"),
    DarkPurple("dark_purple"),
    Gold("gold"),
    Gray("gray"),
    DarkGray("dark_gray"),
    Blue("blue"),
    Green("green"),
    Aqua("aqua"),
    Red("red"),
    LightPurple("light_purple"),
    Yellow("yellow"),
    White("white"),
    Reset("reset"), ;

    companion object {

        fun forName(id: String): Color {
            return enumValueOf<Color>(StrUtil.upperFirst(StrUtil.toCamelCase(id)))
        }

    }

    override fun toString(): String {
        return id
    }

}