package io.kurumi.demo.core

import io.kurumi.app.content.界面

class 界面实例 : 界面() {

    override fun 界面创建事件() {

        标题 = "你好 事件"

        内容 = 垂直布局 {

            填充 = 16

            文本视图 {

                文本 = "你好 Kio!"

            }

        }

    }

}
