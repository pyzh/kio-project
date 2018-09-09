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

import io.kurumi.applyIfNotNull
import io.kurumi.core.连接

var PAN_USER_AGENT = "JUC(Linux;U;2.2;Zh_cn;HTC Desire;480*800;)UCWEB7.7.0.85/139/999"
var PAN_REGEX = "href=\"(http\\:\\/\\/d\\.pcs\\.baidu\\.com\\S*)\"\\sid=".toRegex()

fun 取百度云直链(_链接: String, _回调: (String?) -> Unit) {

    连接(_链接).发送 {

        if (成功) {

            try {

                PAN_REGEX.find(字符!!).applyIfNotNull {

                    val url = value.replace("amp;", "")

                    if (url.startsWith("http")) {

                        _回调(url)

                        return@发送

                    }

                }

            } catch (ignored: Exception) {
            }

        }

        _回调(null)

    }

}

fun 百度云连接(_地址: String): 连接 {

    return 连接(_地址).请求头("User-Agent", PAN_USER_AGENT)

}