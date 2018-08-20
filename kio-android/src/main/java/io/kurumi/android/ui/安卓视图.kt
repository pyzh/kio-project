package io.kurumi.android.ui

import android.view.View
import android.view.ViewGroup
import io.kurumi.android.R
import io.kurumi.android.service.安卓界面服务
import io.kurumi.android.系统服务
import io.kurumi.platform.content.上下文
import io.kurumi.platform.ui.abs.基本视图
import io.kurumi.platform.ui.view.视图
import io.kurumi.util.主线程

open class 安卓视图(val 上下文: 上下文, open val 内容: View = View(安卓界面服务.取安卓上下文(上下文))) : 基本视图 {

    override fun 初始化(_视图: 视图) {

        内容.setTag(R.id._kio_view_obj, _视图)

    }

    var params: ViewGroup.LayoutParams
        get() {
            var f = 内容.layoutParams
            if (f == null) {
                f = ViewGroup.LayoutParams(-2, -2)
                params = f
            }
            return f
        }
        set(value) {
            主线程 {
                内容.layoutParams = value
            }
        }

    override var 宽度: Int
        get() = params.width
        set(value) {
            params.width = value
            params = params
        }

    override var 高度: Int
        get() = params.height
        set(value) {
            params.height = value
            params = params
        }

    override var 宽高: Int
        get() = -1
        set(value) {
            宽度 = value
            高度 = value
        }

    override var 上填充: Int
        get() = px(内容.paddingTop)
        set(value) {
            置填充(value, 下填充, 左填充, 右填充)
        }

    override var 下填充: Int
        get() = px(内容.paddingBottom)
        set(value) {
            置填充(上填充, value, 左填充, 右填充)
        }

    override var 左填充: Int
        get() = px(内容.paddingLeft)
        set(value) {
            置填充(上填充, 下填充, value, 右填充)
        }

    override var 右填充: Int
        get() = px(内容.paddingRight)
        set(value) {}

    override var 填充: Int
        get() = -1
        set(value) {
            置填充(value, value, value, value)
        }

    override fun 置填充(_上: Int, _下: Int, _左: Int, _右: Int) {
        主线程 {
            内容.setPadding(dp(_左), dp(_上), dp(_右), dp(_下))
        }
    }

    override var 显示: Boolean
        get() = 内容.visibility == View.VISIBLE
        set(value) {
            主线程 {
                内容.visibility = if (value) View.VISIBLE else View.GONE
            }
        }

    companion object {

        fun px(dimen: Int): Int {
            return (dimen / 系统服务.屏幕信息.density).toInt()
        }

        fun dp(dimen: Int): Int {
            return (dimen.toFloat() * 系统服务.屏幕信息.density).toInt()
        }

        fun sp(dimen: Int): Int {
            return ((dimen.toFloat() * 系统服务.屏幕信息.scaledDensity) / 系统服务.屏幕信息.density).toInt()
        }

    }

}

fun <T : 视图> View?.取视图(): T? {

    if (this == null) return null

    var _视图 = getTag(R.id._kio_view_obj) as 视图?

    if (_视图 !== null) {
        return _视图 as T
    }

    when (this) {
        else -> TODO()
    }

}