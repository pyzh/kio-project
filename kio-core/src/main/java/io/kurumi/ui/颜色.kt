package io.kurumi.ui

import io.kurumi.content.界面
import java.util.*

class 颜色 constructor(_颜色: Array<String>, _基本颜色键值: Int, _基本深色键值: Int, _强调色键值: Int,val 应用器 :(颜色.(界面) -> Unit)? = null) {

    private val 基本: String
    private val 深色: String
    private val 控件: String

    init {
        基本 = _颜色[_基本颜色键值]
        深色 = _颜色[_基本深色键值]
        控件 = _颜色[_强调色键值]
    }

    companion object {

        val 白色 = "#FFFFFF"
        val 白烟 = "#EBEBEB"
        val 黑色 = "#de000000"
        val 透明 = "#00000000"
        val 半透明 = "#10000000"
        val 白透明 = "#e6eaf7"
        val 黑透明 = "#202020"

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

        var 当前颜色 = 靛蓝

    }

}
