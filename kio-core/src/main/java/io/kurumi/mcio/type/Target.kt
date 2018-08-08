package io.kurumi.mcio.type

import kotlin.collections.LinkedHashMap

/**
 * MC实体操作目标封装
 * 在使用目标选择器之后，你可以随意地使用参数来限定所要选择的群组。
 * 当使用@a或@e时，待选目标从全体筛选成特定的少数。
 * 当使用@p或@r时，待选目标根据距离远近或随机而从全体中产生。
 */
class Target internal constructor(internal val target: String) {

    /**
     * MC目标选择器封装
     * 在目标选择器变量之后附加键值对构成的逗号分隔表，并包含在方括号中：
     * @<变量>[<参数>=<值>,<参数>=<值>,…
     * 键值区分大小写，括号、等于号和逗号旁不能有空格，键值对只能用逗号分隔。
     */
    class Selector() : LinkedHashMap<String, String>() {

        /**
         * 将选择器表装换成选择器字符串
         */
        override fun toString(): String {
            val ret = StringBuilder("[")
            forEach { k, v ->
                if (ret.length != 1) {
                    ret.append(",")
                }
                ret.append("$k=$v")
            }
            return ret.append("]").toString()
        }

    }

    /**
     * 当前选择器
     * 内部使用
     */
    internal val selector = Selector()

    /**
     * 限制选择实体的数量
     *
     * 当使用@p或@r变量时，此参数被预设为1，
     * 而更大的数值会增加回传的目标数量。
     * 当使用@a或@e变量时，此参数只会限制目标数量（默认选择所有目标）。
     *
     * 如果有多名距离最近的实体，距离完全相同，
     * 那么则会根据加载时间来选择。
     *
     * 举例来说，如果距离完全相同，@a[limit=1]
     *
     * 会选择进入服务器时间最久的玩家而@e[type=creeper,limit=3]
     * 会选择最早加载（期间没卸载）的3只爬行者。
     *
     * 当输入的值为负值时，目标的顺序会被反转
     * 举例来说，@p[c=-3] 会回传3个最远的目标
     * 而且，如果所有目标距离都一样远，
     * 例如@e[c=-3] 会选择3个刚加载/生成的目标。
     *
     * sort参数可以对实体进行排序
     * @see sort
     *
     * @param max 最大数量

     */
    fun limit(max: Int): Target {
        selector["limit"] = "$max"
        return this
    }

    /**
     * sort可以对实体进行排序，
     * 排在前的有限数量个实体入选.
     * @param sort 排序方式
     * @see EntrySort
     */
    fun sort(sort: EntrySort): Target {
        selector["sort"] = "$sort"
        return this
    }

    /**
     * 设置基准点
     * @param pos 基准点位置
     * @see Pos
     *
     * 改目标选择器选择的基准点
     * （对选择顺序及部分选择参数有效，并且限制选择范围为执行的世界）。
     *
     * 默认以命令执行位置为基准点，可以只修改部分坐标。
     * 坐标可以是整数或小数（具体为双精度浮点数）
     * 且必须明确
     *
     * 波浪号不可以用于此参数（基岩版除外）。
     * wsserver 只能在基岩版使用 所以没有这个限制
     */
    fun reference(pos: Pos): Target {
        pos.appendToSelector(selector)
        return this
    }

    /**
     * 选择相对基准点指定距离的目标。
     * 可以设置以内 / 以外
     *
     * 如果设置了dz / dy / dz
     * 则选择二者重复的区域内目标
     *
     * @param dis 距离
     * @see Distance
     */
    fun distance(dis: Distance): Target {

        selector["distance"] = "$dis"
        return this
    }

    /**
     * 选择相对基准点x轴指定距离 内 的目标
     * @param dis 距离
     * @see distance
     */
    fun dx(dis: Double): Target {

        selector["dx"] = "$dis"
        return this
    }

    /**
     * 选择相对基准点y轴指定距离 内 的目标
     * @param dis 距离
     * @see distance
     */
    fun dy(dis: Double): Target {

        selector["dy"] = "$dis"
        return this
    }

    /**
     * 选择相对基准点y轴指定距离 内 的目标
     * @param dis 距离
     * @see distance
     */
    fun dz(dis: Double): Target {

        selector["dz"] = "$dis"
        return this
    }

    /**
     * 匹配指定游戏模式的玩家
     * 支持多选
     */
    fun gamemode(vararg modes: GameMode): Target {
        val value = StringBuilder()
        modes.forEach {
            if (value.length == 0) {
                value.append("$it")
            } else {
                value.append(",gamemode=$it")
            }
        }
        selector["gamemode=$value"]
        return this
    }

    @JvmOverloads
            /**
             * 通过名称选择目标
             * 支持空格等特殊字符
             *
             * @param name 名称
             * @param notEquals 是否反向匹配
             */
    fun name(name: String, notEquals: Boolean = false): Target {

        selector["name"] = "${if (notEquals) "!" else ""}\"$name\""
        return this
    }

    /**
     * 选择指定类型的目标
     * 与反选不能同时使用
     * 不支持多选
     *
     * @see Entry
     */
    fun type(entry: String): Target {

        selector["entry"] = entry

        return this

    }

    /**
     * 反选指定类型的目标 支持多项反选
     * @see Entry
     */
    fun typeNotEquals(vararg entrys: String): Target {

        val types = StringBuilder()

        entrys.forEach {
            if (types.length != 0) {
                types.append(",type=")
            }
            types.append("!$it")
        }

        selector["type"] = "$types"

        return this

    }


    /**
     * 转换到操作对象字符串
     */
    override fun toString(): String {

        if (selector.isEmpty()) {

            // 没有选择器 直接返回名称
            return target

        }

        return "$target$selector"

    }

    companion object {

        /**
         * 根据名称创建操作目标
         */
        fun forName(userName: String): Target {
            return Target(userName)
        }

        /**
         * 选择最近的玩家。
         *
         * 作为服务器调用时,
         * 基准点为(0, 0, 0)。
         * 如果有多个最近的玩家，
         * 他们与基准点距离完全相同，
         * 那么会选择其中最晚进入服务器的玩家。
         *
         * 可以进一步筛选待选目标。
         */
        fun nearestPlayer(): Target {
            return Target("@p")
        }

        /**
         * 选择随机玩家
         * 如果没有设置 type 只会选择随机玩家
         *
         * 可以进一步筛选待选目标。
         * 举例来说 : 可以使用limit随机选择多名玩家
         */
        fun randomPlayer(): Target {
            return Target("@r")
        }

        /**
         * 选择所有玩家，包括已死亡玩家。
         *
         * 可以进一步筛选待选目标。
         * 除了此选择器以及 selfEntry() 以外的其它所有目标选择器都不能选中已死亡玩家。
         */
        fun allPlayers(): Target {
            return Target("@a")
        }

        /**
         * 选择所有实体（包含玩家）。
         *
         * 可以进一步筛选待选目标。
         * 例如 : 动物种类等
         */
        fun allEntries(): Target {
            return Target("@e")
        }

        /**
         * 选择命令执行者
         * 只选择唯一一个实体：执行该命令的实体，包括已死亡玩家。
         *
         * 若调用wsserver的不是实体，
         * 例如x86服务器的控制台,
         * 则此选择器不会选中任何东西。
         *
         * 可以进一步筛选命令执行者。
         */
        fun selfEntry(): Target {
            return Target("@s")
        }

    }

}