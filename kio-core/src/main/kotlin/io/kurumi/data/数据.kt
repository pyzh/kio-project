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

package io.kurumi.data

/**
 * 可转换到String的数据类型
 */
interface 数据 {

    object 格式 {
        val 表单 = "multipart/form-data"
        val JSON = "application/json"
    }

    fun 类型(): String {
        return 格式.表单
    }

    interface 监听器<内容 : Any> {

        fun 添加(_内容: Collection<内容>)
        fun 删除(_内容: Collection<内容>)

    }

}