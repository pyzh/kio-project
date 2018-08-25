package io.kurumi.core

expect object 系统 {

    val Linux: Boolean
    val Android: Boolean
    val Mac: Boolean
    val MacOsx: Boolean
    val Win: Boolean
    val WinXp: Boolean
    val Win7: Boolean
    val Win8: Boolean
    val Win10: Boolean

    var 剪切板: String

}