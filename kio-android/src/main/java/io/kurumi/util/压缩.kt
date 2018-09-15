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

import cn.hutool.core.util.ZipUtil

actual object 压缩 {

    actual fun GZIP压缩(_字节: ByteArray): ByteArray {
        return ZipUtil.gzip(_字节)
    }

    actual fun GZIP解压(_字节: ByteArray): ByteArray {
        return ZipUtil.unGzip(_字节)
    }

    actual fun ZLIB压缩(_字节: ByteArray, _等级: Int): ByteArray {
        return ZipUtil.zlib(_字节, _等级)
    }

    actual fun ZLIB解压(_字节: ByteArray): ByteArray {
        return ZipUtil.unZlib(_字节)
    }

}