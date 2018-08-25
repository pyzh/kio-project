package io.kurumi.android

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import io.kurumi.android.app.KurumiActivity
import io.kurumi.android.ui.安卓视图
import java.util.*

open class 安卓界面 : Activity(), 界面.界面实现 {

    @SuppressLint("UseSparseArrays")
    val 权限监听器 = HashMap<Int, (HashMap<String, Boolean>) -> Unit>()

    val root by lazy {
        LinearLayout(this@安卓界面).finally {
            layoutParams = ViewGroup.LayoutParams(-1, -1)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        应用颜色(颜色.当前颜色)
        @Suppress("DEPRECATION")
        titleColor = 0xFFFFF
        setContentView(root)
        提示("r :$root")
    }

    override fun 关闭() {
        finish()
    }

    override val 应用: 应用
        get() = 安卓应用.应用实例

    override var 标题: String
        get() = title.toString()
        set(value) {
            title = value
        }


    override var 内容: 视图?
        get() = root.取视图()
        set(value) {
            requireNotNull(value, { "view obj must bnot be null" })
            root.setTag(R.id._kio_view_obj, value)
            if (value?.实现 !is 安卓视图) error("无效的视图 : $value")
            root.removeAllViews()
            root.addView((value.实现 as 安卓视图).内容, ViewGroup.LayoutParams(-1, -1))
        }

    override fun 应用颜色(_颜色: 颜色) {

        when (_颜色) {
            颜色.红色 -> R.style.Kurumi_Red
            颜色.粉色 -> R.style.Kurumi_Pink
            颜色.紫色 -> R.style.Kurumi_Purple
            颜色.深紫 -> R.style.Kurumi_DeepPurple
            颜色.靛蓝 -> R.style.Kurumi_Indigo
            颜色.蓝色 -> R.style.Kurumi_Blue
            颜色.亮蓝 -> R.style.Kurumi_LightBlue
            颜色.青色 -> R.style.Kurumi_Cyan
            颜色.鸭绿 -> R.style.Kurumi_Teal
            颜色.绿色 -> R.style.Kurumi_Green
            颜色.亮绿 -> R.style.Kurumi_LightGreen
            颜色.酸橙 -> R.style.Kurumi_Lime
            颜色.黄色 -> R.style.Kurumi_Yellow
            颜色.琥珀 -> R.style.Kurumi_Amber
            颜色.橙色 -> R.style.Kurumi_Orange
            颜色.暗橙 -> R.style.Kurumi_DeepOrange
            颜色.棕色 -> R.style.Kurumi_Brown
            颜色.灰色 -> R.style.Kurumi_Green
            颜色.蓝灰 -> R.style.Kurumi_BlueGrey
            else -> null
        }.ifNotNull {
            setTheme(this)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>?, grantResults: IntArray?) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        权限监听器.remove(requestCode).ifNotNull {

            val _结果 = HashMap<String, Boolean>()
            permissions?.forEachIndexed { index, permstr ->
                _结果.put(permstr, grantResults?.get(index) == PackageManager.PERMISSION_GRANTED)
            }

            invoke(_结果)

        }

    }

    override fun 启动界面(_界面: Class<out 界面>) {

        val _意图 = Intent(this, KurumiActivity::class.java)
        _意图.putExtra("_界面", _界面)
        startActivity(_意图)

    }


}
