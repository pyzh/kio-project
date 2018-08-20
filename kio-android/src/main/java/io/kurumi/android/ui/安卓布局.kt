package io.kurumi.android.ui

import android.view.ViewGroup
import android.widget.LinearLayout
import io.kurumi.android.service.安卓界面服务
import io.kurumi.finally
import io.kurumi.ifNotNull
import io.kurumi.platform.content.上下文
import io.kurumi.platform.ui.abs.基本布局
import io.kurumi.platform.ui.view.视图
import io.kurumi.util.主线程
import java.util.*

open class 安卓布局(_上下文: 上下文, override val 内容: ViewGroup = LinearLayout(安卓界面服务.取安卓上下文(_上下文))) : 安卓视图(_上下文, 内容), 基本布局 {

    override fun 加入子视图(vararg _视图: 视图) {
        主线程 {
            _视图.forEach {
                内容.addView((it.实现 as 安卓视图).内容)
            }
        }
    }

    override fun 取子视图(_键值: Int): 视图? {
        return 内容.getChildAt(_键值).取视图()
    }

    override fun 取子视图(): MutableCollection<视图> {
        val _子视图 = LinkedList<视图>()
        for (_键值: Int in 0..内容.childCount) {
            内容.getChildAt(_键值).取视图<视图>().ifNotNull {
                _子视图.add(this)
            }
        }
        return _子视图
    }

    override fun 删子视图(_键值: Int): 视图? {
        return 取子视图(_键值).ifNotNull {
            主线程 {
                内容.removeViewAt(_键值)
            }
        }
    }

    override fun 删子视图(): MutableCollection<视图> {
        return 取子视图().finally {
            主线程 {
                内容.removeAllViews()
            }
        }
    }

}