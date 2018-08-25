@file:Suppress("UNCHECKED_CAST")

package io.kurumi

expect object Kio {

    fun toByteArray(str: String): ByteArray
    fun fromByteArray(bytes: ByteArray): String

}

val String.bytes get() = Kio.toByteArray(this)
val ByteArray.string get() = Kio.fromByteArray(this)

const val SPACE = " "
const val TAB = "	"
const val DOT = "."
const val DOUBLE_DOT = ".."
const val SLASH = "/"
const val BACKSLASH = "\\"
const val EMPTY = ""
const val CR = "\r"
const val LF = "\n"
const val CRLF = "\r\n"
const val UNDERLINE = "_"
const val DASHED = "-"
const val COMMA = ","
const val DELIM_START = "{"
const val DELIM_END = "}"
const val BRACKET_START = "["
const val BRACKET_END = "]"
const val COLON = ":"

const val HTML_NBSP = "&nbsp;"
const val HTML_AMP = "&amp;"
const val HTML_QUOTE = "&quot;"
const val HTML_APOS = "&apos;"
const val HTML_LT = "&lt;"
const val HTML_GT = "&gt;"

const val EMPTY_JSON = "{}"

inline fun <T : Boolean?> T.applyIfTrue(_exec: () -> Unit): T {

    if (this == true) {
        _exec.invoke()
    }

    return this

}

inline fun <T : Boolean?> T.applyIfFalse(_exec: () -> Unit): T {

    if (this == false) {
        _exec.invoke()
    }

    return this

}

inline fun <T> T.applyIfNotNull(_exec: T.() -> Unit): T {

    if (this != null) {
        _exec.invoke(this)
    }

    return this

}

fun <T> Array<T>.arrString(_分割: String = "", transer: (T) -> String = {
    it.toString()
}): String {
    val str = StringBuilder()
    forEach {
        str.append(transer.invoke(it))
    }
    return str.toString()

}

inline fun <T : Any> T?.ifNull(_exec: T?.() -> T): T? {

    return if (this == null) {
        _exec.invoke(this)
    } else this

}

fun <Str : String?> Str.append(str: String): Str {

    return if (this != null) {
        "$this$str" as Str
    } else null as Str

}

inline fun <Ex : Exception, R : Any?> (() -> R).catch(_exec: (Ex) -> R): R {

    try {
        return invoke()
    } catch (ex: Exception) {
        return _exec.invoke(ex as Ex)
    }

}

fun <E, T> Array<E>.arrayTrans(transer: E.() -> T): Array<T> {

    val new = ArrayList<T>()
    forEach {
        new.add(transer.invoke(it))
    }
    return new.toTypedArray()

}

inline fun <T : Any, R> T.synchronized(exec: () -> R): R {
    return synchronized(this as Any, exec)
}