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

package io.kurumi.wiki.protocols

import io.kurumi.applyIfNotNull
import io.kurumi.core.连接
import io.kurumi.data.JSON列表
import io.kurumi.origin
import io.kurumi.util.异步
import io.kurumi.wiki.Wiki
import io.kurumi.wiki.WikiItem

/**
 * MediaWiki 通用API
 * 见 https://en.wikipedia.org/w/api.php
 */

interface MediaWiki : Wiki {

    /**
     * MediaWiki api.php的地址
     * 通常为 域名/api.php 或 域名/w/api.php
     */
    val 地址: String

    override fun 搜索(_内容: String, _回调: (List<WikiItem>) -> Unit) {

        异步 {

            val c = 连接(地址)

            if (origin != "") {
                c.参数("origin", origin)
            }
            c.参数("action", "query")
            c.参数("generator", "prefixsearch")
            c.参数("gpssearch", _内容)
            c.参数("format", "json")
            c.发送 {

                if (成功) {

                    val json = JSON!!
                    val pages = json.取JSON("query")?.取JSON列表("pages") as JSON列表
                    val titles = ArrayList<String>()
                    pages.applyIfNotNull {
                        forEachIndexed { index, _ ->
                            取JSON(index)?.getString("title")?.applyIfNotNull {
                                titles.add(this)
                            }
                        }
                    }
                }

            }

        }

    }
}