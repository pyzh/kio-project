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

package io.kurumi.core

import android.content.ClipData
import io.kurumi.android.安卓应用
import io.kurumi.android.系统服务
import io.kurumi.jvm.*

actual object 系统 {

    actual val Linux: Boolean = _Linux
    actual val Android: Boolean = _Android
    actual val Mac: Boolean = _Mac
    actual val MacOsx: Boolean = _MacOsx
    actual val Win: Boolean = _Win
    actual val WinXp: Boolean = _WinXp
    actual val Win7: Boolean = _Win7
    actual val Win8: Boolean = _Win8
    actual val Win10: Boolean = _Win10

    actual var 剪切板: String
        get() {
            val _数据 = 系统服务.剪切板.primaryClip
            if (_数据 != null && _数据.itemCount > 0) {
                return _数据.getItemAt(0).coerceToText(安卓应用.实例).toString()
            }
            return ""
        }
        set(value) {
            系统服务.剪切板.primaryClip = ClipData.newPlainText(null, value)
        }

}