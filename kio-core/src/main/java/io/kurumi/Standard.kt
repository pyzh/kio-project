@file:JvmName("KioStandard")

package io.kurumi

import java.util.*

inline fun <T : Any> T?.ifNotNull(_exec: T.() -> Unit) {

    if (this != null) {
        _exec.invoke(this)
    }

}

inline fun <This, reified T> Array<This>.arrayTrans(transer: This.() -> T): Array<T> {

    val new = LinkedList<T>()
    forEach {
        new.add(transer.invoke(it))
    }
    return new.toTypedArray()

}