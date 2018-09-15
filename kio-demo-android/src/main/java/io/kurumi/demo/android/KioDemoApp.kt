package io.kurumi.demo.android

import android.content.Context
import io.kurumi.android.安卓应用
import io.kurumi.demo.core.界面实例

class KioDemoApp : 安卓应用() {

    override fun 应用启动事件(_上下文: Context) {

        启动界面(界面实例::class)

    }

}