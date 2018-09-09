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

package io.kurumi.net

import io.kurumi.util.提示


object RconClientTest {

    @JvmStatic
    fun main(args: Array<String>) {

        val client = RconClient("61.147.247.137", 10034, "zMDliY2U4N")

        if (client.connect()) {
            提示(client.exec("list"))
        } else {
            提示("connect failed")
        }
    }

}