package io.kurumi.android.app

import android.os.Bundle
import io.kurumi.android.安卓界面

class KurumiActivity : 安卓界面() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @Suppress("UNCHECKED_CAST")
        val clazz = intent.getSerializableExtra("_界面") as Class<out 界面>?
        if (clazz != null) {
            val _界面 = clazz.newInstance()
            _界面.初始化实现(this)
            _界面.界面创建事件()
        } else {
            finish()
        }
    }
}