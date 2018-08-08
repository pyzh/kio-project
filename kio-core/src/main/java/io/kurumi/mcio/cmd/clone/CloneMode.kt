package io.kurumi.mcio.cmd.clone

/**
 * 复制模式
 * (clone命令的参数)
 */
enum class CloneMode(val mode : String) {

    /**
     * 强制复制，即使源区域与目标区域有重叠。
     */
    Force("force"),

    /**
     * 替换为空气。在filtered遮罩模式下，只有被复制的方块才会被替换为空气。
     */
    Move("move"),

    /**
     * 默认模式
     * 不执行force或move
     */
    Normal("normal");

    override fun toString(): String {
        return mode
    }

}