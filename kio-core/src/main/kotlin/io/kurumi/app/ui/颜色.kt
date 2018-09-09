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

package io.kurumi.app.ui

data class 颜色 constructor(val 所有: Array<String>, val 基本色键值: Int, val 基本深色键值: Int, val 强调色键值: Int)
    : Comparable<颜色> {

    val 基本: Int
    val 深色: Int
    val 控件: Int

    init {
        基本 = 解析(所有[基本色键值])
        深色 = 解析(所有[基本深色键值])
        控件 = 解析(所有[强调色键值])
    }

    override fun compareTo(other: 颜色): Int {
        return if (基本色键值 == other.基本色键值 &&
                基本深色键值 == other.基本深色键值 &&
                强调色键值 == other.强调色键值 &&
                所有.contentEquals(other.所有)) 0 else -1
    }

    companion object {

        val 白色 = 解析("#FFFFFF")
        val 白烟 = 解析("#EBEBEB")
        val 黑色 = 解析("#de000000")
        val 透明 = 解析("#00000000")
        val 半透明 = 解析("#10000000")
        val 白透明 = 解析("#e6eaf7")
        val 黑透明 = 解析("#202020")

        val 红色 = 颜色(arrayOf("#FFEBEE", "#FFCDD2", "#EF9A9A", "#E57373", "#EF5350", "#F44336", "#E53935", "#D32F2F", "#C62828", "#B71C1C", "#FF8A80", "#FF5252", "#FF1744", "#D50000"), 5, 7, 11)
        val 粉色 = 颜色(arrayOf("#FCE4EC", "#F8BBD0", "#F48FB1", "#F06292", "#EC407A", "#E91E63", "#D81B60", "#C2185B", "#AD1457", "#880E4F", "#FF80AB", "#FF4081", "#F50057", "#C51162"), 5, 7, 11)
        val 紫色 = 颜色(arrayOf("#F3E5F5", "#E1BEE7", "#CE93D8", "#BA68C8", "#AB47BC", "#9C27B0", "#8E24AA", "#7B1FA2", "#6A1B9A", "#4A148C", "#EA80FC", "#E040FB", "#D500F9", "#AA00FF"), 5, 7, 11)
        val 深紫 = 颜色(arrayOf("#EDE7F6", "#D1C4E9", "#B39DDB", "#9575CD", "#7E57C2", "#673AB7", "#5E35B1", "#512DA8", "#4527A0", "#311B92", "#B388FF", "#7C4DFF", "#651FFF", "#6200EA"), 5, 7, 11)
        val 靛蓝 = 颜色(arrayOf("#E8EAF6", "#C5CAE9", "#9FA8DA", "#7986CB", "#5C6BC0", "#3F51B5", "#3949AB", "#303F9F", "#283593", "#1A237E", "#8C9EFF", "#536DFE", "#3D5AFE", "#304FFE"), 5, 7, 11)
        val 蓝色 = 颜色(arrayOf("#E3F2FD", "#BBDEFB", "#90CAF9", "#64B5F6", "#42A5F5", "#2196F3", "#1E88E5", "#1976D2", "#1565C0", "#0D47A1", "#82B1FF", "#448AFF", "#2979FF", "#2962FF"), 5, 7, 11)
        val 亮蓝 = 颜色(arrayOf("#E1F5FE", "#B3E5FC", "#81D4FA", "#4FC3F7", "#29B6F6", "#03A9F4", "#039BE5", "#0288D1", "#0277BD", "#01579B", "#80D8FF", "#40C4FF", "#00B0FF", "#0091EA"), 5, 7, 11)
        val 青色 = 颜色(arrayOf("#E0F7FA", "#B2EBF2", "#80DEEA", "#4DD0E1", "#26C6DA", "#00BCD4", "#00ACC1", "#0097A7", "#00838F", "#006064", "#84FFFF", "#18FFFF", "#00E5FF", "#00B8D4"), 5, 7, 11)
        val 鸭绿 = 颜色(arrayOf("#E0F2F1", "#B2DFDB", "#80CBC4", "#4DB6AC", "#26A69A", "#009688", "#00897B", "#00796B", "#00695C", "#004D40", "#A7FFEB", "#64FFDA", "#1DE9B6", "#00BFA5"), 5, 7, 11)
        val 绿色 = 颜色(arrayOf("#E8F5E9", "#C8E6C9", "#A5D6A7", "#81C784", "#66BB6A", "#4CAF50", "#43A047", "#388E3C", "#2E7D32", "#1B5E20", "#B9F6CA", "#69F0AE", "#00E676", "#00C853"), 5, 7, 11)
        val 亮绿 = 颜色(arrayOf("#F1F8E9", "#DCEDC8", "#C5E1A5", "#AED581", "#9CCC65", "#8BC34A", "#7CB342", "#689F38", "#558B2F", "#33691E", "#CCFF90", "#B2FF59", "#76FF03", "#64DD17"), 5, 7, 11)
        val 酸橙 = 颜色(arrayOf("#F9FBE7", "#F0F4C3", "#E6EE9C", "#DCE775", "#D4E157", "#CDDC39", "#C0CA33", "#AFB42B", "#9E9D24", "#827717", "#F4FF81", "#EEFF41", "#C6FF00", "#AEEA00"), 5, 7, 11)
        val 黄色 = 颜色(arrayOf("#FFFDE7", "#FFF9C4", "#FFF59D", "#FFF176", "#FFEE58", "#FFEB3B", "#FDD835", "#FBC02D", "#F9A825", "#F57F17", "#FFFF8D", "#FFFF00", "#FFEA00", "#FFD600"), 5, 7, 11)
        val 琥珀 = 颜色(arrayOf("#FFF8E1", "#FFECB3", "#FFE082", "#FFD54F", "#FFCA28", "#FFC107", "#FFB300", "#FFA000", "#FF8F00", "#FF6F00", "#FFE57F", "#FFD740", "#FFC400", "#FFAB00"), 5, 7, 11)
        val 橙色 = 颜色(arrayOf("#FFF3E0", "#FFE0B2", "#FFCC80", "#FFB74D", "#FFA726", "#FF9800", "#FB8C00", "#F57C00", "#EF6C00", "#E65100", "#FFD180", "#FFAB40", "#FF9100", "#FF6D00"), 5, 7, 11)
        val 暗橙 = 颜色(arrayOf("#FBE9E7", "#FFCCBC", "#FFAB91", "#FF8A65", "#FF7043", "#FF5722", "#F4511E", "#E64A19", "#D84315", "#BF360C", "#FF9E80", "#FF6E40", "#FF3D00", "#DD2C00"), 5, 7, 11)
        val 棕色 = 颜色(arrayOf("#EFEBE9", "#D7CCC8", "#BCAAA4", "#A1887F", "#8D6E63", "#795548", "#6D4C41", "#5D4037", "#4E342E", "#3E2723"), 5, 7, 5)
        val 灰色 = 颜色(arrayOf("#FAFAFA", "#F5F5F5", "#EEEEEE", "#E0E0E0", "#BDBDBD", "#9E9E9E", "#757575", "#616161", "#424242", "#212121"), 5, 7, 5)
        val 蓝灰 = 颜色(arrayOf("#ECEFF1", "#CFD8DC", "#B0BEC5", "#90A4AE", "#78909C", "#607D8B", "#546E7A", "#455A64", "#37474F", "#263238"), 5, 7, 5)

        var 基本 = 靛蓝
        var 强调 = 粉色

        private val sColorNameMap = HashMap<String, Int>()

        fun 解析(_颜色: String): Int {
            if (_颜色.get(0) == '#') {
                // Use a long to avoid rollovers on #ffXXXXXX
                var color = _颜色.substring(1, 16).toLong()
                if (_颜色.length == 7) {
                    // Set the alpha value
                    color = color or -0x1000000
                } else if (_颜色.length != 9) {
                    error("未知的颜色 : $color")
                }
                return color.toInt()
            } else {
                val color = sColorNameMap.get(_颜色.toUpperCase())
                if (color != null) {
                    return color
                }
                error("未知的颜色 : $color")
            }
        }

        fun 转换(_颜色: Int): String {
            return "#${red(_颜色)}${green(_颜色)}${blue(_颜色)}${alpha(_颜色)}"
        }

        fun alpha(color: Int): Int {
            return color.ushr(24)
        }

        fun red(color: Int): Int {
            return color shr 16 and 0xFF
        }

        fun green(color: Int): Int {
            return color shr 8 and 0xFF
        }

        fun blue(color: Int): Int {
            return color and 0xFF
        }

    }


}