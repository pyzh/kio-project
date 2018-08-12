package io.kurumi.desktop.ui.view

import io.kurumi.content.上下文
import io.kurumi.ui.abs.基本布局
import io.kurumi.ui.view.视图
import javafx.collections.ListChangeListener
import javafx.scene.Node
import javafx.scene.layout.Pane
import java.util.*

open class 桌面布局(_上下文: 上下文, override val 内容: Pane = Pane()) : 桌面视图(_上下文, 内容), 基本布局 {

    private val 子视图 = LinkedList<视图>()

    init {
        内容?.children?.addListener(this::子视图改变事件)
    }

    private fun 子视图改变事件(_改变: ListChangeListener.Change<out Node>) {

        if (_改变.next()) {

            for (_键值 in _改变.from until _改变.to) {
                if (_改变.wasRemoved()) {
                    子视图.removeAt(_键值)
                } else {
                    子视图.set(_键值, _改变.list[_键值].properties[键值_视图] as 视图)
                }
            }

        }

    }

    override fun 加入子视图(vararg _视图: 视图) {

        for (_单个 in _视图) {

            if (_单个.实现 !is 桌面视图) throw IllegalStateException("不支持的视图实现")

            val _实现 = _单个.实现 as 桌面视图

            内容.children.add(_实现.内容)

        }

    }

    override fun 取子视图(_键值: Int): 视图 {
        return 内容.children[_键值].userData as 视图
    }

    override fun 取子视图(): MutableCollection<视图> {
        return 子视图
    }

    override fun 删子视图(_键值: Int): 视图 {
        return 内容.children.removeAt(_键值).properties[键值_视图] as 视图
    }

    @Suppress("UNCHECKED_CAST")
    override fun 删子视图(): MutableCollection<视图> {
        val _所有 = 子视图.clone() as MutableCollection<视图>
        内容.children.removeAll()
        return _所有
    }

}
