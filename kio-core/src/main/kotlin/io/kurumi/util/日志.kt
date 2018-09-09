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

package io.kurumi.util

interface 基本日志 {

    fun 打印(level: 等级, log: Any?)

    enum class 等级 {
        Debug, Info, Warning, Error
    }

}

expect object 默认 : 基本日志

var 日志 = 默认

fun 日志(log: Any?) {
    日志.打印(基本日志.等级.Debug, log)
}

fun 提示(log: Any?) {
    日志.打印(基本日志.等级.Info, log)
}

fun 警告(log: Any?) {
    日志.打印(基本日志.等级.Warning, log)
}

fun 错误(log: Any?) {
    日志.打印(基本日志.等级.Error, log)
}

