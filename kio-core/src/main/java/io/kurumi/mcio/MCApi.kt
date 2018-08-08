
package io.kurumi.mcio

import io.kurumi.mcio.cmd.CmdManager
import io.kurumi.mcio.cmd.CmdResp
import io.kurumi.mcio.cmd.clone.CloneMode
import io.kurumi.mcio.cmd.clone.MaskMode
import io.kurumi.mcio.type.Item
import io.kurumi.mcio.type.Pos
import io.kurumi.mcio.type.Target

class MCApi(val cmd: CmdManager) {


    /**
     * 清空玩家物品栏的物品。
     *
     * 以下参数全部可选
     *
     * @param target 玩家
     *  若未定义则默认为命令执行者。
     *
     *  @param item 物品类型
     *  指定将被清除的物品的ID。
     *  若未定义则清除物品栏中所有物品。
     *  @see Item
     *
     *  @param count 数量
     *  若未指定或定义为-1，
\
     *  则所有符合物品值的物品会被清除而不考虑物品数据。
     *
     *  根据测试 基岩版已经不支持传入数据值(数据id了)
     *
     */
    @JvmOverloads
    fun clear(target: Target? = null, item: String? = null, count: Int? = null): CmdResp {
        return cmd.send("clear", target, item, count)
    }

    /**
     * 在区域之间复制方块结构。
     *
     * @param begin 开始坐标
     * @param end 结束坐标
     *
     * 定义源区域的两组对角方块坐标
     *
     * 可以使用相对距离
     * @see Pos.相对坐标
     *
     * 构成边角的方块在此方块的坐标正方向上延伸。
     * 因此，各轴上较小的坐标将会正好贴合区域边界，
     * 但较大的坐标将会超过边界1方块，
     * 源区域的体积则为(x大 - x小 + 1) × (y大 - y小 + 1) × (z大 - z小 + 1)。
     *
     * 例如：0 0 0 0 0 0的体积为1方块，
     * 0 0 0 1 1 1与1 1 1 0 0 0都指定同一块8方块大小的区域。
     *
     * @param destination 各轴坐标较小的角
     *
     * 定义目标区域的西北方向较低（即在各轴上坐标较小）的角
     *
     * 可以使用相对距离
     * @see Pos.相对坐标
     *
     * @param maskmode 遮罩模式 (可选)
     * 指定是否过滤被复制方块
     * @see MaskMode
     *
     * 当遮罩模式为filtered(复制指定方块)时
     * 必须指定方块(block)
     *
     * @param clonemode 复制模式 (可选)
     * 指定对源区域的操作
     * @see CloneMode
     *
     * @param block
     *
     */
    fun clone(begin : Pos, end : Pos, destination : Pos, maskmode : MaskMode?, clonemode : CloneMode?, block : String?): CmdResp {

        if (maskmode == MaskMode.Filtered && block == null) {
            throw IllegalArgumentException("Invalid filtered maskMode without block name");
        }

        return cmd.send("clone", begin, end, destination)

    }

    fun say(text : String) : CmdResp {

        return cmd.send("say", MCText.replaceWith16("$text"))

    }


}