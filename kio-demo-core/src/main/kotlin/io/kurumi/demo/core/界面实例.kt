package io.kurumi.demo.core

import io.kurumi.app.content.界面
import io.kurumi.util.提示

class 界面实例 : 界面() {

    override fun 界面创建事件() {

        标题 = "你好 世界"

        内容 = 垂直布局 {

            填充 = 16

            文本视图 {
                文本 = "你好 Kio!"
            }

            垂直布局 { 填充 = 4 }

            按钮 {

                文本 = "一个按钮 ~"

                单击事件 {

                    提示("你单击我力,,,")

                }

            }

        }

    }

}
