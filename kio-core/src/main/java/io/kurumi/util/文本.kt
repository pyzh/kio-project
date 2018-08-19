package io.kurumi.util

import org.fusesource.jansi.Ansi.ansi

open class 文本() {

    private val str = ansi()

    open fun black(text: String): 文本 {
        str.fgBlack().a(text)
        return this
    }

    open fun brightBlack(text: String): 文本 {
        str.fgBrightBlack().a(text)
        return this
    }

    open fun blue(text: String): 文本 {
        str.fgBlue().a(text)
        return this
    }

    open fun brightBlue(text: String): 文本 {
        str.fgBrightBlue().a(text)
        return this
    }

    open fun cyan(text: String): 文本 {
        str.fgCyan().a(text)
        return this
    }


    open fun brightCyan(text: String): 文本 {
        str.fgBrightCyan().a(text)
        return this
    }


    open fun default(text: String): 文本 {
        str.fgDefault().a(text)
        return this
    }

    open fun brightDefault(text: String): 文本 {
        str.fgBrightDefault().a(text)
        return this
    }

    open fun green(text: String): 文本 {
        str.fgGreen().a(text)
        return this
    }


    open fun brightGreen(text: String): 文本 {
        str.fgBrightGreen().a(text)
        return this
    }

    open fun magenta(text: String): 文本 {
        str.fgMagenta().a(text)
        return this
    }


    open fun brightMagenta(text: String): 文本 {
        str.fgBrightMagenta().a(text)
        return this
    }

    open fun red(text: String): 文本 {
        str.fgRed().a(text)
        return this
    }


    open fun brightRed(text: String): 文本 {
        str.fgBrightRed().a(text)
        return this
    }

    open fun yellow(text: String): 文本 {
        str.fgYellow().a(text)
        return this
    }

    open fun brightYellow(text: String): 文本 {
        str.fgBrightYellow().a(text)
        return this
    }

    open fun reset(): 文本 {
        str.reset()
        return this
    }

    override fun toString(): String {
        return str.toString()
    }


}