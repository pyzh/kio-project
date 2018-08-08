package io.kurumi.mcio

import cn.hutool.core.util.CharUtil
import cn.hutool.core.util.EscapeUtil

class MCText {

    val ESCAPE_CHAR = '\u00a7'
    val BLACK_STRING = ESCAPE_CHAR + "0"
    val DARK_BLUE_STRING = ESCAPE_CHAR + "1"
    val DARK_GREEN_STRING = ESCAPE_CHAR + "2"
    val DARK_AQUA_STRING = ESCAPE_CHAR + "3"
    val DARK_RED_STRING = ESCAPE_CHAR + "4"
    val DARK_PURPLE_STRING = ESCAPE_CHAR + "5"
    val GOLD_STRING = ESCAPE_CHAR + "6"
    val GRAY_STRING = ESCAPE_CHAR + "7"
    val DARK_GRAY_STRING = ESCAPE_CHAR + "8"
    val BLUE_STRING = ESCAPE_CHAR + "9"

    val GREEN_STRING = ESCAPE_CHAR + "a"
    val AQUA_STRING = ESCAPE_CHAR + "b"
    val RED_STRING = ESCAPE_CHAR + "c"
    val LIGHT_PURPLE_STRING = ESCAPE_CHAR + "d"
    val YELLOW_STRING = ESCAPE_CHAR + "e"
    val WHITE_STRING = ESCAPE_CHAR + "f"

    val RESET_STRING = ESCAPE_CHAR + "r"

    val str = StringBuilder()

    fun gold(text: String): MCText {
        str.append(GOLD_STRING).append(text)
        return this
    }

    fun gray(text: String): MCText {
        str.append(GREEN_STRING).append(text)
        return this
    }

    fun darkGray(text: String): MCText {
        str.append(DARK_RED_STRING).append(text)
        return this
    }

    fun darkPurple(text: String): MCText {
        str.append(DARK_PURPLE_STRING).append(text)
        return this
    }

    fun purple(text: String): MCText {
        str.append(LIGHT_PURPLE_STRING).append(text)
        return this
    }

    fun black(text: String): MCText {
        str.append(BLACK_STRING).append(text)
        return this
    }

    fun darkBlue(text: String): MCText {
        str.append(DARK_BLUE_STRING).append(text)
        return this
    }

    fun blue(text: String): MCText {
        str.append(BLUE_STRING).append(text)
        return this
    }

    fun aqua(text: String): MCText {
        str.append(AQUA_STRING).append(text)
        return this
    }

    fun darkAqua(text: String): MCText {
        str.append(AQUA_STRING).append(text)
        return this
    }

    fun darkGreen(text: String): MCText {
        str.append(DARK_GREEN_STRING).append(text)
        return this
    }

    fun green(text: String): MCText {
        str.append(GREEN_STRING).append(text)
        return this
    }

    fun darkRed(text: String): MCText {
        str.append(DARK_RED_STRING).append(text)
        return this
    }

    fun red(text: String): MCText {
        str.append(RED_STRING).append(text)
        return this
    }

    fun yellow(text: String): MCText {
        str.append(YELLOW_STRING).append(text)
        return this
    }

    fun reset(): MCText {
        str.append(RESET_STRING)
        return this
    }

    override fun toString(): String {
        return str.toString()
    }

    companion object {

        fun replaceWith16(str : String) : String {

            val ret  = StringBuilder()

            str.forEach {

                if (CharUtil.isAscii(it)) {
                    ret.append(it)
                } else {
                    ret.append("\\x")
                    ret.append(Integer.toHexString(it.toInt()))
                }

            }

            return ret.toString()

        }

    }

}