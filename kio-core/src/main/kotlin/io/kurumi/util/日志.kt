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

package io.kurumi.util

expect interface 日志 {

    fun 调试(_内容: String)
    fun 提示(_内容: String)
    fun 警告(_内容: String)

    companion object : 日志

}

fun 调试(_内容: String) = 日志.调试(_内容)
fun 提示(_内容: String) = 日志.提示(_内容)
fun 警告(_内容: String) = 日志.警告(_内容)