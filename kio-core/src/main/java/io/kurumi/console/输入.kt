package io.kurumi.console

import java.io.InputStream
import java.util.*

class 输入() {

    val s = Scanner(System.`in`)

    fun next() : String {

        return s.nextLine()

    }

    fun hasNext() : Boolean {

        return s.hasNext()

    }

}