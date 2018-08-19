package io.kurumi.android.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import io.kurumi.android.R
import io.kurumi.android.安卓应用
import io.kurumi.android.安卓界面
import io.kurumi.android.系统服务
import io.kurumi.content.上下文
import io.kurumi.content.界面
import io.kurumi.ui.abs.基本视图
import io.kurumi.ui.view.视图

class 安卓视图(val 上下文: 上下文, val 内容: View) : 基本视图 {

    override fun 初始化(_视图: 视图) {

        内容.setTag(R.id._kio_view_obj, _视图)

    }

    var params: ViewGroup.LayoutParams
        get() {
            var f = 内容.layoutParams
            if (f == null) {
                f = ViewGroup.LayoutParams(-2, -2)
                内容.layoutParams = f
            }
            return f
        }
        set(value) {
            内容.layoutParams = value
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
        内容.setPadding(dp(_左), dp(_上), dp(_右), dp(_下))
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


        fun getContext(_上下文: 上下文): Context {
            if (_上下文 is 界面) {
                return _上下文.实现 as 安卓界面
            } else {
                return 安卓应用.实例
            }
        }

    }

}