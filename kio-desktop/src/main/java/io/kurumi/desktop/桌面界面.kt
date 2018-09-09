/*
 * Copyright 2018 MikaGuraNTK
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package io.kurumi.desktop

import cn.hutool.core.util.ReflectUtil
import com.jfoenix.controls.JFXDecorator
import io.kurumi.append
import io.kurumi.desktop.ui.view.桌面视图
import io.kurumi.app.content.上下文
import io.kurumi.app.content.应用
import io.kurumi.app.content.界面
import io.kurumi.app.ui.view.视图
import io.kurumi.app.ui.颜色
import javafx.scene.Scene
import javafx.scene.layout.VBox
import javafx.stage.Screen
import javafx.stage.Stage

class 桌面界面(override val 应用: 应用) : Stage(), 界面.界面实现 {

    val content = VBox()
    val root = JFXDecorator(this, content)

    init {
        root.styleClass.add(颜色.当前颜色.取基本深色())

        var width = 800.0
        var height = 600.0
        try {
            val bounds = Screen.getScreens()[0].bounds
            width = bounds.width / 2.5
            height = bounds.height / 1.35
        } catch (ignored: Exception) {
        }

        this.scene = Scene(content, width, height)
        scene.stylesheets.addAll(
                this::class.java.getResource("/css/jfoenix-fonts.css").toExternalForm(),
                this::class.java.getResource("/css/jfoenix-design.css").toExternalForm()
        )
    }

    override var 标题: String
        get() = root.title
        set(value) {
            root.title = value
        }

    override var 内容: 视图?
        get() = userData as 视图?
        set(value) {

            if (value == null) error("vlaue cannot be null")

            if (value.实现 !is 桌面视图) {
                throw IllegalStateException("不支持的视图实现")
            }

            val _内容 = value.实现 as 桌面视图

            content.children.removeAll()
            content.children.add(_内容.内容)

        }

    fun 颜色.取颜色名(): String? {
        return when (this) {
            颜色.红色 -> "red"
            颜色.粉色 -> "pink"
            颜色.紫色 -> "purple"
            颜色.深紫 -> "deep-purple"
            颜色.靛蓝 -> "indigo"
            颜色.蓝色 -> "blue"
            颜色.亮蓝 -> "light-blue"
            颜色.青色 -> "cyan"
            颜色.鸭绿 -> "real"
            颜色.绿色 -> "green"
            颜色.亮绿 -> "light-green"
            颜色.酸橙 -> "lime"
            颜色.黄色 -> "yellow"
            颜色.琥珀 -> "amber"
            颜色.橙色 -> "orange"
            颜色.暗橙 -> "deep-orange"
            颜色.棕色 -> "brown"
            颜色.灰色 -> "green"
            颜色.蓝灰 -> "blue-green"
            else -> null
        }
    }

    fun 颜色.取基本色(): String? {
        return 取颜色名().append("-500")
    }

    fun 颜色.取基本深色(): String? {
        return 取颜色名().append("-700")
    }

    fun 颜色.取控件色(): String? {
        return 取颜色名().append(when (this) {
            颜色.棕色, 颜色.灰色, 颜色.蓝灰 -> "-500"
            else -> "-A200"
        })
    }

    override fun 应用颜色(_颜色: 颜色) {
    }

    override fun 关闭() {
        hide()
    }

    companion object {

        fun 启动界面(_上下文: 上下文, _界面: Class<out 界面>) {

            val _实现 = 桌面界面(_上下文.应用)

            val _实例 = ReflectUtil.newInstance(_界面)

            _实例.初始化实现(_实现)

            _实例.界面创建事件()

            _实现.show()

        }
    }


}