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

package io.kurumi.jvm

val osName = System.getProperty("os.name")
val osVersion = System.getProperty("os.version")

val _Linux = osName.contains("Linux") || osName.contains("LINUX")
val _Android = _Linux && "Dalvik" == System.getProperty("java.vm.name")
val _Mac = !_Linux && osName.contains("Mac")
val _MacOsx = _Mac && osName.contains("Mac OS X")
val _Win = !_Linux && !_Mac && osName.contains("Windows")
val _WinXp = _Win && osVersion.contains("5.1")
val _Win7 = _Win && osVersion.contains("6.1")
val _Win8 = _Win && (osVersion.contains("6.2") || osName.contains("6.3"))
val _Win10 = _Win && osVersion.contains("10.0")