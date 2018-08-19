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


inline fun <T : Any> T.finally(_exec: T?.() -> Unit): T {

    _exec.invoke(this)

    return this

}

inline fun <This, reified T> Array<This>.arrayTrans(transer: This.() -> T): Array<T> {

    val new = LinkedList<T>()
    forEach {
        new.add(transer.invoke(it))
    }
    return new.toTypedArray()

}