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

package io.kurumi

import com.sun.javafx.application.PlatformImpl
import javafx.application.Platform

actual object Kio {

    init {

        PlatformImpl.startup {}

    }

    fun 主线程(_执行: () -> Unit) {
        Platform.runLater(_执行)
    }

    actual fun toByteArray(str: String): ByteArray {
        return str.toByteArray()
    }

    actual fun fromByteArray(bytes: ByteArray): String {
        return String(bytes)
    }

}