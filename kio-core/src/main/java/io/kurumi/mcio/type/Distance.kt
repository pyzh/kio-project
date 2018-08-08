package io.kurumi.mcio.type

/**
 * MC距离封装 通常用于选择器中
 * 可以是格数 也可以是分数(score)距离
 * 
 * 选择器的distance参数可以限制目标与基准点的距离。
 * 比如，[distance=..3]表示
 * （与基准点的）距离在3格以内的实体（也就是半径为3的球形区域），
 * [distance=3..]表示距离不小于3个的实体，
 * [distance=1..3]表示距离在1格与3格之间的实体.
 *
 * @see Target
 */
class Distance() {

    /**
     * 限定在指定分数/格数
     * 如果需要具体限制距离 请使用 静态方法创建
     */
    constructor(pos : Double) : this() {

        from = pos
        to = from

    }

    var from = Double.NaN
    var to = from
    
    /** 
     * 距离是否无效 (起始距离大于结束距离)
     */
    val isNaN get() = (from == Double.NaN && to == Double.NaN) || to - from < 0
    
    /**
     * 转换成选择器距离
     */
    override fun toString(): String {
        if (isNaN) {
            throw IllegalStateException("Invalid distance!")
        }
        return if (from == Double.NaN) {
            "..${to.toInt()}"
        } else if (to == Double.NaN) {
            "${from.toInt()}.."
        } else {
            "${from.toInt()}..${to.toInt()}"
        }
    }

    companion object {

        /**
         * 创建指定格数/分数以外的距离
         * @param from 起始分数/相对基准点距离
         */
        fun from(from : Double) : Distance {
            val dis = Distance()
            dis.from = from
            return dis
        }

        /**
         * 创建指定格数/分数以内的距离
         * @param to 封顶分数/相对基准点的距离
         */
        fun to(to : Double) : Distance {
            val dis = Distance()
            dis.to = to
            return dis
        }

        /**
         * 创建指定格数/分数之内的距离
         * @param from 起始分数/相对基准点距离
         * @param to 封顶分数/相对基准点的距离
         */
        fun create(from : Double,to: Double) : Distance {
            val dis = Distance()
            dis.from = from
            dis.to = to
            return dis
        }

    }

}