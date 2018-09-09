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