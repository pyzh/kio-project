package io.kurumi.android.test

import io.kurumi.android.安卓应用
import io.kurumi.platform.content.应用

class TestApp : 安卓应用() {

    override val 应用: Class<out 应用>
        get() = 测试应用::class.java
}