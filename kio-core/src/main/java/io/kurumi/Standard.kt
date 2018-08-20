@file:JvmName("KioStandard")

package io.kurumi

import java.util.*

inline fun <T : Any> T?.ifNotNull(_exec: T.() -> Unit): T? {

    if (this != null) {
        _exec.invoke(this)
    }

    return this

}

inline fun <T : Any> T?.ifNull(_exec: T?.() -> T): T {

    return if (this == null) {
        _exec.invoke(this)
    } else this

}

inline fun String?.append(str: String): String? {

    return if (this != null) {
        "$this$str"
    } else null

}

inline fun <T : Any?> T.finally(_exec: T.() -> Unit): T {

    _exec.invoke(this)

    return this

}

inline fun <reified Ex : Exception> (() -> Any?).catch(_exec: (Ex) -> Unit) {

    try {
        invoke()
    } catch (ex: Exception) {
        _exec.invoke(ex as Ex)
    }

}

inline fun <This, reified T> Array<This>.arrayTrans(transer: This.() -> T): Array<T> {

    val new = LinkedList<T>()
    forEach {
        new.add(transer.invoke(it))
    }
    return new.toTypedArray()

}