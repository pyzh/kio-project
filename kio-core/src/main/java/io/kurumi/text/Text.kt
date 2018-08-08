package io.kurumi.text

import org.fusesource.jansi.Ansi
import org.fusesource.jansi.Ansi.ansi
import org.fusesource.jansi.AnsiConsole

open class Text() {

    private val str = ansi()

    open fun black(text: String): Text {
        str.fgBlack().a(text)
        return this
    }
    
    open fun brightBlack(text: String): Text {
        str.fgBrightBlack().a(text)
        return this
    }

    open fun blue(text: String): Text {
        str.fgBlue().a(text)
        return this
    }

    open fun brightBlue(text: String): Text {
        str.fgBrightBlue().a(text)
        return this
    }

    open fun cyan(text: String): Text {
        str.fgCyan().a(text)
        return this
    }


    open fun brightCyan(text: String): Text {
        str.fgBrightCyan().a(text)
        return this
    }


    open fun default(text: String): Text {
        str.fgDefault().a(text)
        return this
    }

    open fun brightDefault(text: String): Text {
        str.fgBrightDefault().a(text)
        return this
    }

    open fun green(text: String): Text {
        str.fgGreen().a(text)
        return this
    }


    open fun brightGreen(text: String): Text {
        str.fgBrightGreen().a(text)
        return this
    }

    open fun magenta(text: String): Text {
        str.fgMagenta().a(text)
        return this
    }


    open fun brightMagenta(text: String): Text {
        str.fgBrightMagenta().a(text)
        return this
    }

    open fun red(text: String): Text {
        str.fgRed().a(text)
        return this
    }


    open fun brightRed(text: String): Text {
        str.fgBrightRed().a(text)
        return this
    }

    open fun yellow(text: String): Text {
        str.fgYellow().a(text)
        return this
    }

    open fun brightYellow(text: String): Text {
        str.fgBrightYellow().a(text)
        return this
    }

    open fun reset() : Text {
        str.reset()
        return this
    }

    override fun toString(): String {
        return str.toString()
    }


}