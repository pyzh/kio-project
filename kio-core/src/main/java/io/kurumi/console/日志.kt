package io.kurumi.console

import io.kurumi.text.Text
import java.util.*

var 当前日志: 日志 = 日志.Default()

fun debug(log : Any?) {
    当前日志.打印(日志.Level.Debug,log)
}

fun info(log: Any?) {
    当前日志.打印(日志.Level.Info,log)
}

fun warn(log: Any?) {
    当前日志.打印(日志.Level.Warning,log)
}

fun err(log: Any?) {
    当前日志.打印(日志.Level.Error,log)
}

interface 日志 {

    
    
    fun 打印(level: Level, log: Any?)

    enum class Level {
        Debug, Info, Warning, Error
    }

    class Default : 日志 {

        override fun 打印(level: Level, log: Any?) {

            val text = Text()
                    .blue("[Kurimi]")
                    .green("[${Date().toLocaleString()}]")
                    .red("[${level.name}] ")

            append(level, text, log?.toString() ?: "null")

            println(text.reset())


        }

        fun append(level: Level, text: Text, log: String): Text {

            when (level) {

                Level.Debug -> text.default(log)
                Level.Info -> text.cyan(log)
                Level.Warning -> text.yellow(log)
                Level.Error -> text.red(log)

            }

            return text
        }

    }

}
