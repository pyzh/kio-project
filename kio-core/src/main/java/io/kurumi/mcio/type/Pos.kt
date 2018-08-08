package io.kurumi.mcio.type

import java.lang.Double.NaN

/**
 * MC坐标封装
 *
 * 大多数以玩家作为参数的命令，
 * 可以通过某些限定条件来选择一个或多个玩家，
 * 而不必要用名字来指定玩家。
 *
 * 要用条件来选择玩家，
 * 先选择一个目标选择器变量，
 * 然后，可选地，选择一个或多个目标选择器参数以制定具体的条件。
 */
class Pos {

    companion object {

        /**
         * 波浪号
         *
         * 很多命令可以使用波浪号（~）来指定相对坐标。
         *
         * 在波浪号后方的数字是个偏移量而不是绝对坐标。
         * 数字的正负号表示以坐标轴的正或负方向偏移。
         * 一个单独的波浪号~是~0的简写。
         *
         * 举例来说，/tp 0 64 0 将会移动使用者到坐标(0, 64, 0)，
         * 而tp ~3 ~ ~-3会使使用者往x轴移动3米（东方），
         * 保持原本高度，并在z轴移动-3米(北方)。
         *
         * 偏移量的基准点由命令本身决定。
         * 一般以命令的执行位置为基准点。
         *
         *  Pos类封装了相对坐标(rz,rz,ry)
         * 通常绝对坐标和相对坐标可以混合使用。
         *
         * 如果定义了相对坐标 会忽略局部坐标
         * (相对/局部 不能混合使用)
         *
         */
        const val 相对坐标 = "~"

        /**
         * 插入符
         *
         * 很多命令可以使用插入符（^）来指定局部坐标。
         *
         * 局部坐标即以执行位置为基准点，
         * 执行者左、上、前为坐标轴，计算目标坐标。
         *
         * 在插入符后方的数字是指定方向的偏移量而不是绝对坐标。
         *
         * 数字的正负号表示以坐标轴的正或负方向偏移。
         * 一个单独的插入符^是^0的简写。
         *
         * 举例来说，setblock ^ ^ ^3 stone 会在执行者前方第三格放置一块石头。
         *
         * Pos类封装了绝对坐标(left等)
         * 通常绝对坐标和局部坐标不能混合使用。
         * (例如clone方块)
         *
         * 如果定义了相对坐标 会忽略局部坐标
         * (相对/局部 不能混合使用)
         */
        const val 局部坐标 = "^"

        /**
         * 解析xzy值成坐标
         */
        fun parse(x: String, z: String, y: String) {

            val ret = Pos()

            if (x.startsWith(相对坐标)) {

                ret.rx = if (x.length == 1) 0.0 else {
                    x.substring(1).toDouble()
                }

            } else if (x.startsWith(局部坐标)) {

                ret.left = if (x.length == 1) 0.0 else {
                    x.substring(1).toDouble()
                }

            } else {

                ret.x = x.toDouble()

            }


            if (z.startsWith(相对坐标)) {

                ret.rz = if (z.length == 1) 0.0 else {
                    z.substring(1).toDouble()
                }

            } else if (z.startsWith(局部坐标)) {

                ret.top = if (z.length == 1) 0.0 else {
                    z.substring(1).toDouble()
                }

            } else {

                ret.z = z.toDouble()

            }


            if (y.startsWith(相对坐标)) {

                ret.ry = if (y.length == 1) 0.0 else {
                    y.substring(1).toDouble()
                }

            } else if (y.startsWith(局部坐标)) {

                ret.front = if (y.length == 1) 0.0 else {
                    y.substring(1).toDouble()
                }

            } else {

                ret.y = y.toDouble()

            }

        }

    }

    /**
     * 绝对坐标x值
     */
    var x = NaN

    /**
     * 绝对坐标y值
     */
    var y = NaN

    /**
     * 绝对坐标z值
     */
    var z = NaN


    /**
     * 相对坐标x值
     */
    var rx = NaN

    /**
     * 相对坐标y值
     */
    var ry = NaN

    /**
     * 相对坐标z值
     */
    var rz = NaN

    /**
     * 局部坐标x值(目标左边)
     */
    var left = NaN

    /**
     * 反向局部坐标x值(目标右边)
     */
    var right = NaN

    /**
     * 局部坐标z值(目标上边)
     */
    var top = NaN

    /**
     * 反向局部坐标z值(目标下边)
     */
    var bottom = NaN

    /**
     * 局部坐标y值(目标前面)
     */
    var front = NaN

    /**
     * 反向局部坐标y值(目标后面)
     */
    var back = NaN

    /**
     * 实际绝对坐标x值(转换后的)
     */
    val cx get() = cal(x, rz, left, right)

    /**
     * 实际绝对坐标z值(转换后的)
     */
    val cz get() = cal(z, rz, top, bottom);

    /**
     * 实际绝对坐标y值(转换后的)
     */
    val cy get() = cal(y, ry, front, back)

    /**
     * 转换成参数形式
     */
    override fun toString(): String {
        return "$cx $cz $cy"
    }

    /**
     * 装换成选择器形式
     * @see Target.Selector
     * @param s 选择器
     */
    fun appendToSelector(s: Target.Selector) {

        s["x"] = cx
        s["z"] = cz
        s["y"] = cy

    }

    /**
     * 将左右值装换成实际坐标值
     * 内部使用
     * @param d 绝对坐标
     * @param r 相对坐标
     * @param la 局部坐标
     * @param lb 反向绝对坐标
     */
    internal fun cal(d: Double, r: Double, la: Double, lb: Double): String {

        if (notNaN(rx, ry, rz)) {

            // 默认相对坐标优先于局部坐标

            return if (d != NaN) "$d" else "$相对坐标${if (!r.isNaN()) r.toString() else ""}"

        } else if (notNaN(la, lb)) {

            return "$局部坐标${(if (la.isNaN()) 0.0 else la) - (if (lb.isNaN()) 0.0 else lb)}"

        } else {

            return 局部坐标;

        }

    }

    /**
     * 检测传入是是否不全部为空
     * 内部使用
     */
    internal fun notNaN(vararg args: Double): Boolean {

        return args.any { !it.isNaN() }

    }


}