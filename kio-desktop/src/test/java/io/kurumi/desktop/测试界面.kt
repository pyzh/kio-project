package io.kurumi.desktop

import io.kurumi.platform.content.界面
import io.kurumi.platform.ui.view.垂直布局
import io.kurumi.platform.ui.view.文本视图

class 测试界面 : 界面() {

    override fun 界面创建事件() {

        标题 = "Hello Kio"

        内容 = 垂直布局 {

            填充 = 16

            val 文本 = 文本视图 {

                文本 = "你好 世界 !"

            }

        }

    }
}