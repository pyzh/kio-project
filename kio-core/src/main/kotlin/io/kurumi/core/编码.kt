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

import io.kurumi.bytes
import io.kurumi.string
import kotlin.experimental.or

interface 编码 {

    fun 编码(_内容: ByteArray): ByteArray
    fun 解码(_内容: ByteArray): ByteArray?

    fun 编码(_内容: String): ByteArray {
        return 编码(_内容.bytes)
    }

    fun 解码(_内容: String): ByteArray? {
        return 解码(_内容.bytes)
    }

    fun 编码到文本(_内容: ByteArray): String {
        return 编码(_内容).string
    }

    fun 编码到文本(_内容: String): String {
        return 编码(_内容).string
    }

    fun 解码到文本(_内容: ByteArray): String? {
        return 解码(_内容)?.string
    }

    fun 解码到文本(_内容: String): String? {
        return 解码(_内容)?.string
    }

    /**
     * Base32 - encodes and decodes RFC3548 Base32 (see http://www.faqs.org/rfcs/rfc3548.html )<br></br>
     * base32就是用32（2的5次方）个特定ASCII码来表示256个ASCII码。<br></br>
     * 所以，5个ASCII字符经过base32编码后会变为8个字符（公约数为40），长度增加3/5.不足8n用“=”补足。
     * see http://blog.csdn.net/earbao/article/details/44453937
     * @author Looly
     */
    object Base32 : 编码 {


        override fun 编码(_内容: ByteArray): ByteArray {
            return encode(_内容).bytes
        }

        override fun 解码(_内容: ByteArray): ByteArray? {
            return decode(_内容.string)
        }

        private val base32Chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567"
        private val base32Lookup = intArrayOf(//
                0xFF, 0xFF, 0x1A, 0x1B, 0x1C, 0x1D, 0x1E, 0x1F, // '0', '1', '2', '3', '4', '5', '6', '7'
                0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, // '8', '9', ':', ';', '<', '=', '>', '?'
                0xFF, 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, // '@', 'A', 'B', 'C', 'D', 'E', 'F', 'G'
                0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, // 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O'
                0x0F, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, // 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W'
                0x17, 0x18, 0x19, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, // 'X', 'Y', 'Z', '[', '\', ']', '^', '_'
                0xFF, 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, // '`', 'a', 'b', 'c', 'd', 'e', 'f', 'g'
                0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, // 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o'
                0x0F, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, // 'p', 'q', 'r', 's', 't', 'u', 'v', 'w'
                0x17, 0x18, 0x19, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF // 'x', 'y', 'z', '{', '|', '}', '~', 'DEL'
        )

        //----------------------------------------------------------------------------------------- encode
        /**
         * 编码
         * @param bytes 数据
         * @return base32
         */
        fun encode(bytes: ByteArray): String {
            var i = 0
            var index = 0
            var digit = 0
            var currByte: Int
            var nextByte: Int
            val base32 = StringBuilder((bytes.size + 7) * 8 / 5)

            while (i < bytes.size) {
                currByte = if (bytes[i] >= 0) bytes[i].toInt() else bytes[i] + 256 // unsign

                /* Is the current digit going to span a byte boundary? */
                if (index > 3) {
                    if (i + 1 < bytes.size) {
                        nextByte = if (bytes[i + 1] >= 0) bytes[i + 1].toInt() else bytes[i + 1] + 256
                    } else {
                        nextByte = 0
                    }

                    digit = currByte and (0xFF shr index)
                    index = (index + 5) % 8
                    digit = digit shl index
                    digit = digit or (nextByte shr 8 - index)
                    i++
                } else {
                    digit = currByte shr 8 - (index + 5) and 0x1F
                    index = (index + 5) % 8
                    if (index == 0) {
                        i++
                    }
                }
                base32.append(base32Chars[digit])
            }

            return base32.toString()
        }

        //----------------------------------------------------------------------------------------- decode
        /**
         * 解码
         * @param base32 base32编码
         * @return 数据
         */
        fun decode(base32: String): ByteArray {
            var i: Int
            var index: Int
            var lookup: Int
            var offset: Int
            var digit: Int
            val bytes = ByteArray(base32.length * 5 / 8)

            i = 0
            index = 0
            offset = 0
            while (i < base32.length) {
                lookup = base32[i] - '0'

                /* Skip chars outside the lookup table */
                if (lookup < 0 || lookup >= base32Lookup.size) {
                    i++
                    continue
                }

                digit = base32Lookup[lookup]

                /* If this digit is not in the table, ignore it */
                if (digit == 0xFF) {
                    i++
                    continue
                }

                if (index <= 3) {
                    index = (index + 5) % 8
                    if (index == 0) {
                        bytes[offset] = bytes[offset] or digit.toByte()
                        offset++
                        if (offset >= bytes.size) {
                            break
                        }
                    } else {
                        bytes[offset] = bytes[offset] or (digit shl 8 - index).toByte()
                    }
                } else {
                    index = (index + 5) % 8
                    bytes[offset] = bytes[offset] or digit.ushr(index).toByte()
                    offset++

                    if (offset >= bytes.size) {
                        break
                    }
                    bytes[offset] = bytes[offset] or (digit shl 8 - index).toByte()
                }
                i++
            }
            return bytes
        }

    }

    class 链接 : 编码 by 链接编码实现
    class Unicode : 编码 by Unicode编码实现

}

expect object 链接编码实现 : 编码
expect object Unicode编码实现 : 编码