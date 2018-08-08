package io.kurumi.mcio.cmd.clone

/**
 * 遮罩模式 clone 命令的可选参数
 *
 * 若未定义，默认为 replace。
 */
enum class MaskMode(val mode: String) {

    /**
     * 仅复制指定方块
     * (需要指定clone)
     */
    Filtered("filtered"),

    /**
     * 复制非空气方块
     */
    Masked("masked"),

    /**
     * 复制所有方块
     */
    Replace("replace");

    override fun toString(): String {
        return mode
    }

}