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

expect open class 线程池 {

    constructor()
    constructor(_最大线程: Int)

    fun 处理(_执行: () -> Unit)

    companion object : 线程池

}

fun 异步(_执行: () -> Unit) {

    线程池.处理(_执行)

}