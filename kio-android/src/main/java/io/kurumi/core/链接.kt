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

import cn.hutool.core.exceptions.UtilException
import cn.hutool.core.text.UnicodeUtil
import cn.hutool.core.util.URLUtil
import io.kurumi.bytes
import io.kurumi.catch
import io.kurumi.string


actual object 链接编码实现 : 编码 {

    override fun 编码(_内容: ByteArray): ByteArray {
        return URLUtil.encode(_内容.string).bytes
    }

    override fun 解码(_内容: ByteArray): ByteArray? {
        return { URLUtil.decode(_内容.string).bytes }.catch<UtilException, ByteArray?> { null }
    }

}

actual object Unicode编码实现 : 编码 {

    override fun 编码(_内容: ByteArray): ByteArray {
        return UnicodeUtil.toUnicode(_内容.string).bytes
    }

    override fun 解码(_内容: ByteArray): ByteArray? {
        return UnicodeUtil.toString(_内容.string).bytes
    }
}