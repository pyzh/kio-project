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

import cn.hutool.core.util.ClipboardUtil
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
        get() = ClipboardUtil.getStr()
        set(value) {
            ClipboardUtil.setStr(value)
        }


}