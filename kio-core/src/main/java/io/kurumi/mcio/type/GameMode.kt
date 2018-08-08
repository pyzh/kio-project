package io.kurumi.mcio.type

import cn.hutool.core.util.StrUtil

/**
 * 游戏模式
 */
enum class GameMode(val modeName: String) {

    // 生存模式
    Survival("survival"),

    // 创造模式
    Creative("creative"),

    // 冒险模式
    Adventure("adventure"),

    // 旁观模式
    Spectator("spectator");

    override fun toString(): String {
        return modeName
    }

    companion object {

        fun keyTrans(key: Any?): String {

            return when (key?.toString()) {
                "0" -> Survival.name
                "1" -> Creative.name
                "3" -> Adventure.name
                "4" -> Spectator.name
                else -> StrUtil.upperFirst(key?.toString())
            }

        }

    }

}