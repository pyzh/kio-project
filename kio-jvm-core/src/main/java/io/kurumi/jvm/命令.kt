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

object 命令实现 {

    fun 可用(): Boolean {
        return true
    }

    fun 执行(_命令: String, _回调: (_成功: Boolean, _结果: String) -> Unit = { _, _ ->
    }) {
        try {
            val _进程 = Runtime.getRuntime().exec(_命令)
            _回调(_进程.exitValue() == 0, String(_进程.errorStream.readBytes()))
        } catch (ex: Exception) {
            _回调(false, ex.toString())
        }
    }


}