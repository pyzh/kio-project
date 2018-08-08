package io.kurumi.mcio.type

/**
 * 实体排序规则
 */
enum class EntrySort(val sort : String) {

    /**
     * 表示最近的实体。
     * 比如@a[sort=nearest,limit=1]相当于@p。
     */
    Nearest("nearest"),

    /**
     * 表示最远的实体。
     * 比如@a[sort=furthest,limit=3]相当于1.13之前的@p[c=-3]。
     */
    Furthest("furthest"),

    /**
     * 表示随机排序。
     * @a[sort=random,limit=1]相当于@r。
     */
    Random("random"),

    /**
     * 默认根据 加载时间 和 距离 排序
     * 如果有多名距离最近的实体，距离完全相同，
     * 那么则会根据加载时间来选择。
     *
     * 是@a和@e的默认排序方式。
     */
    Arbitrary("arbitrary");

    override fun toString(): String {
        return sort
    }
}