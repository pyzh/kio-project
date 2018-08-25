package io.kurumi

actual object Kio {

    actual fun toByteArray(str: String): ByteArray {
        return str.toByteArray()
    }

    actual fun fromByteArray(bytes: ByteArray): String {
        return String(bytes)
    }

}