/*
 * Copyright 2018 MikaGuraNTK
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

@file:JvmName("KioExt")
package io.kurumi

import android.os.Handler
import android.os.Looper

actual object Kio {

    actual fun toByteArray(str: String): ByteArray {
        return str.toByteArray()
    }

    actual fun fromByteArray(bytes: ByteArray): String {
        return String(bytes)
    }


}


private val mainHandler = Handler(Looper.getMainLooper())

fun 主线程(_执行: () -> Unit) {
    if (Thread.currentThread() == Looper.getMainLooper().thread) {
        _执行.invoke()
    } else {
        mainHandler.post(_执行)
    }
}