/*
 * Copyright 2018 MikaGuraNTK
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.kurumi.core

import cn.hutool.core.util.ClipboardUtil

actual object 系统 {

    val osName = System.getProperty("os.name")!!
    val osVersion = System.getProperty("os.version")!!

    actual val Linux = osName.contains("Linux") || osName.contains("LINUX")
    actual val Android = Linux && "Dalvik" == System.getProperty("java.vm.name")
    actual val Mac = !Linux && osName.contains("Mac")
    actual val MacOsx = Mac && osName.contains("Mac OS X")
    actual val Win = !Linux && !Mac && osName.contains("Windows")
    actual val WinXp = Win && osVersion.contains("5.1")
    actual val Win7 = Win && osVersion.contains("6.1")
    actual val Win8 = Win && (osVersion.contains("6.2") || osName.contains("6.3"))
    actual val Win10 = Win && osVersion.contains("10.0")

    actual var 剪切板: String
        get() = ClipboardUtil.getStr()
        set(value) {
            ClipboardUtil.setStr(value)
        }


}