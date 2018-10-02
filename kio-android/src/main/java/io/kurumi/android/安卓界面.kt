/*
 * Copyright 2018 MikaGuraNTK
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package io.kurumi.android

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import io.kurumi.android.app.KurumiActivity
import io.kurumi.android.ui.*
import io.kurumi.app.content.基本界面
import io.kurumi.app.content.界面
import io.kurumi.app.ui.abs.*
import io.kurumi.app.ui.颜色
import io.kurumi.applyIfNotNull
import java.util.*
import kotlin.reflect.KClass

open class 安卓界面 : Activity(), 基本界面 {

    @SuppressLint("UseSparseArrays")
    val 权限监听器 = HashMap<Int, (HashMap<String, Boolean>) -> Unit>()

    val root by lazy {
        LinearLayout(this@安卓界面).apply {
            layoutParams = ViewGroup.LayoutParams(-1, -1)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("DEPRECATION")
        titleColor = 0xFFFFF
        setContentView(root)
        应用颜色()
    }

    override fun 关闭() {
        finish()
    }

    override var 标题: String
        get() = title.toString()
        set(value) {
            title = value
        }


    override var 内容: 视图?
        get() = root.getTag(R.id._kio_view_obj) as 视图?
        set(value) {
            requireNotNull(value, { "视图不能为空" })
            root.setTag(R.id._kio_view_obj, value)
            if (value !is 安卓视图) error("无效的视图 : $value")
            root.removeAllViews()
            root.addView(value.内容, ViewGroup.LayoutParams(-1, -1))
        }

    override fun 应用颜色() {

        when (颜色.基本) {
            颜色.红色 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Red_Red
                颜色.粉色 -> R.style.Kurumi_Red_Pink
                颜色.紫色 -> R.style.Kurumi_Red_Purple
                颜色.深紫 -> R.style.Kurumi_Red_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Red_Indigo
                颜色.蓝色 -> R.style.Kurumi_Red_Blue
                颜色.亮蓝 -> R.style.Kurumi_Red_LightBlue
                颜色.青色 -> R.style.Kurumi_Red_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Red_Teal
                颜色.绿色 -> R.style.Kurumi_Red_Green
                颜色.亮绿 -> R.style.Kurumi_Red_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Red_Lime
                颜色.黄色 -> R.style.Kurumi_Red_Yellow
                颜色.琥珀 -> R.style.Kurumi_Red_Amber
                颜色.橙色 -> R.style.Kurumi_Red_Orange
                颜色.暗橙 -> R.style.Kurumi_Red_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Red_Brown
                颜色.灰色 -> R.style.Kurumi_Red_Green
                颜色.蓝灰 -> R.style.Kurumi_Red_BlueGrey
                else -> null
            }
            颜色.粉色 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Pink_Red
                颜色.粉色 -> R.style.Kurumi_Pink_Pink
                颜色.紫色 -> R.style.Kurumi_Pink_Purple
                颜色.深紫 -> R.style.Kurumi_Pink_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Pink_Indigo
                颜色.蓝色 -> R.style.Kurumi_Pink_Blue
                颜色.亮蓝 -> R.style.Kurumi_Pink_LightBlue
                颜色.青色 -> R.style.Kurumi_Pink_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Pink_Teal
                颜色.绿色 -> R.style.Kurumi_Pink_Green
                颜色.亮绿 -> R.style.Kurumi_Pink_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Pink_Lime
                颜色.黄色 -> R.style.Kurumi_Pink_Yellow
                颜色.琥珀 -> R.style.Kurumi_Pink_Amber
                颜色.橙色 -> R.style.Kurumi_Pink_Orange
                颜色.暗橙 -> R.style.Kurumi_Pink_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Pink_Brown
                颜色.灰色 -> R.style.Kurumi_Pink_Green
                颜色.蓝灰 -> R.style.Kurumi_Pink_BlueGrey
                else -> null
            }
            颜色.紫色 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Purple_Red
                颜色.粉色 -> R.style.Kurumi_Purple_Pink
                颜色.紫色 -> R.style.Kurumi_Purple_Purple
                颜色.深紫 -> R.style.Kurumi_Purple_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Purple_Indigo
                颜色.蓝色 -> R.style.Kurumi_Purple_Blue
                颜色.亮蓝 -> R.style.Kurumi_Purple_LightBlue
                颜色.青色 -> R.style.Kurumi_Purple_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Purple_Teal
                颜色.绿色 -> R.style.Kurumi_Purple_Green
                颜色.亮绿 -> R.style.Kurumi_Purple_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Purple_Lime
                颜色.黄色 -> R.style.Kurumi_Purple_Yellow
                颜色.琥珀 -> R.style.Kurumi_Purple_Amber
                颜色.橙色 -> R.style.Kurumi_Purple_Orange
                颜色.暗橙 -> R.style.Kurumi_Purple_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Purple_Brown
                颜色.灰色 -> R.style.Kurumi_Purple_Green
                颜色.蓝灰 -> R.style.Kurumi_Purple_BlueGrey
                else -> null
            }
            颜色.深紫 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_DeepPurple_Red
                颜色.粉色 -> R.style.Kurumi_DeepPurple_Pink
                颜色.紫色 -> R.style.Kurumi_DeepPurple_Purple
                颜色.深紫 -> R.style.Kurumi_DeepPurple_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_DeepPurple_Indigo
                颜色.蓝色 -> R.style.Kurumi_DeepPurple_Blue
                颜色.亮蓝 -> R.style.Kurumi_DeepPurple_LightBlue
                颜色.青色 -> R.style.Kurumi_DeepPurple_Cyan
                颜色.鸭绿 -> R.style.Kurumi_DeepPurple_Teal
                颜色.绿色 -> R.style.Kurumi_DeepPurple_Green
                颜色.亮绿 -> R.style.Kurumi_DeepPurple_LightGreen
                颜色.酸橙 -> R.style.Kurumi_DeepPurple_Lime
                颜色.黄色 -> R.style.Kurumi_DeepPurple_Yellow
                颜色.琥珀 -> R.style.Kurumi_DeepPurple_Amber
                颜色.橙色 -> R.style.Kurumi_DeepPurple_Orange
                颜色.暗橙 -> R.style.Kurumi_DeepPurple_DeepOrange
                颜色.棕色 -> R.style.Kurumi_DeepPurple_Brown
                颜色.灰色 -> R.style.Kurumi_DeepPurple_Green
                颜色.蓝灰 -> R.style.Kurumi_DeepPurple_BlueGrey
                else -> null
            }
            颜色.靛蓝 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Indigo_Red
                颜色.粉色 -> R.style.Kurumi_Indigo_Pink
                颜色.紫色 -> R.style.Kurumi_Indigo_Purple
                颜色.深紫 -> R.style.Kurumi_Indigo_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Indigo_Indigo
                颜色.蓝色 -> R.style.Kurumi_Indigo_Blue
                颜色.亮蓝 -> R.style.Kurumi_Indigo_LightBlue
                颜色.青色 -> R.style.Kurumi_Indigo_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Indigo_Teal
                颜色.绿色 -> R.style.Kurumi_Indigo_Green
                颜色.亮绿 -> R.style.Kurumi_Indigo_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Indigo_Lime
                颜色.黄色 -> R.style.Kurumi_Indigo_Yellow
                颜色.琥珀 -> R.style.Kurumi_Indigo_Amber
                颜色.橙色 -> R.style.Kurumi_Indigo_Orange
                颜色.暗橙 -> R.style.Kurumi_Indigo_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Indigo_Brown
                颜色.灰色 -> R.style.Kurumi_Indigo_Green
                颜色.蓝灰 -> R.style.Kurumi_Indigo_BlueGrey
                else -> null
            }
            颜色.蓝色 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Blue_Red
                颜色.粉色 -> R.style.Kurumi_Blue_Pink
                颜色.紫色 -> R.style.Kurumi_Blue_Purple
                颜色.深紫 -> R.style.Kurumi_Blue_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Blue_Indigo
                颜色.蓝色 -> R.style.Kurumi_Blue_Blue
                颜色.亮蓝 -> R.style.Kurumi_Blue_LightBlue
                颜色.青色 -> R.style.Kurumi_Blue_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Blue_Teal
                颜色.绿色 -> R.style.Kurumi_Blue_Green
                颜色.亮绿 -> R.style.Kurumi_Blue_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Blue_Lime
                颜色.黄色 -> R.style.Kurumi_Blue_Yellow
                颜色.琥珀 -> R.style.Kurumi_Blue_Amber
                颜色.橙色 -> R.style.Kurumi_Blue_Orange
                颜色.暗橙 -> R.style.Kurumi_Blue_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Blue_Brown
                颜色.灰色 -> R.style.Kurumi_Blue_Green
                颜色.蓝灰 -> R.style.Kurumi_Blue_BlueGrey
                else -> null
            }
            颜色.亮蓝 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_LightBlue_Red
                颜色.粉色 -> R.style.Kurumi_LightBlue_Pink
                颜色.紫色 -> R.style.Kurumi_LightBlue_Purple
                颜色.深紫 -> R.style.Kurumi_LightBlue_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_LightBlue_Indigo
                颜色.蓝色 -> R.style.Kurumi_LightBlue_Blue
                颜色.亮蓝 -> R.style.Kurumi_LightBlue_LightBlue
                颜色.青色 -> R.style.Kurumi_LightBlue_Cyan
                颜色.鸭绿 -> R.style.Kurumi_LightBlue_Teal
                颜色.绿色 -> R.style.Kurumi_LightBlue_Green
                颜色.亮绿 -> R.style.Kurumi_LightBlue_LightGreen
                颜色.酸橙 -> R.style.Kurumi_LightBlue_Lime
                颜色.黄色 -> R.style.Kurumi_LightBlue_Yellow
                颜色.琥珀 -> R.style.Kurumi_LightBlue_Amber
                颜色.橙色 -> R.style.Kurumi_LightBlue_Orange
                颜色.暗橙 -> R.style.Kurumi_LightBlue_DeepOrange
                颜色.棕色 -> R.style.Kurumi_LightBlue_Brown
                颜色.灰色 -> R.style.Kurumi_LightBlue_Green
                颜色.蓝灰 -> R.style.Kurumi_LightBlue_BlueGrey
                else -> null
            }
            颜色.青色 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Cyan_Red
                颜色.粉色 -> R.style.Kurumi_Cyan_Pink
                颜色.紫色 -> R.style.Kurumi_Cyan_Purple
                颜色.深紫 -> R.style.Kurumi_Cyan_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Cyan_Indigo
                颜色.蓝色 -> R.style.Kurumi_Cyan_Blue
                颜色.亮蓝 -> R.style.Kurumi_Cyan_LightBlue
                颜色.青色 -> R.style.Kurumi_Cyan_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Cyan_Teal
                颜色.绿色 -> R.style.Kurumi_Cyan_Green
                颜色.亮绿 -> R.style.Kurumi_Cyan_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Cyan_Lime
                颜色.黄色 -> R.style.Kurumi_Cyan_Yellow
                颜色.琥珀 -> R.style.Kurumi_Cyan_Amber
                颜色.橙色 -> R.style.Kurumi_Cyan_Orange
                颜色.暗橙 -> R.style.Kurumi_Cyan_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Cyan_Brown
                颜色.灰色 -> R.style.Kurumi_Cyan_Green
                颜色.蓝灰 -> R.style.Kurumi_Cyan_BlueGrey
                else -> null
            }
            颜色.鸭绿 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Teal_Red
                颜色.粉色 -> R.style.Kurumi_Teal_Pink
                颜色.紫色 -> R.style.Kurumi_Teal_Purple
                颜色.深紫 -> R.style.Kurumi_Teal_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Teal_Indigo
                颜色.蓝色 -> R.style.Kurumi_Teal_Blue
                颜色.亮蓝 -> R.style.Kurumi_Teal_LightBlue
                颜色.青色 -> R.style.Kurumi_Teal_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Teal_Teal
                颜色.绿色 -> R.style.Kurumi_Teal_Green
                颜色.亮绿 -> R.style.Kurumi_Teal_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Teal_Lime
                颜色.黄色 -> R.style.Kurumi_Teal_Yellow
                颜色.琥珀 -> R.style.Kurumi_Teal_Amber
                颜色.橙色 -> R.style.Kurumi_Teal_Orange
                颜色.暗橙 -> R.style.Kurumi_Teal_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Teal_Brown
                颜色.灰色 -> R.style.Kurumi_Teal_Green
                颜色.蓝灰 -> R.style.Kurumi_Teal_BlueGrey
                else -> null
            }
            颜色.绿色 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Green_Red
                颜色.粉色 -> R.style.Kurumi_Green_Pink
                颜色.紫色 -> R.style.Kurumi_Green_Purple
                颜色.深紫 -> R.style.Kurumi_Green_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Green_Indigo
                颜色.蓝色 -> R.style.Kurumi_Green_Blue
                颜色.亮蓝 -> R.style.Kurumi_Green_LightBlue
                颜色.青色 -> R.style.Kurumi_Green_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Green_Teal
                颜色.绿色 -> R.style.Kurumi_Green_Green
                颜色.亮绿 -> R.style.Kurumi_Green_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Green_Lime
                颜色.黄色 -> R.style.Kurumi_Green_Yellow
                颜色.琥珀 -> R.style.Kurumi_Green_Amber
                颜色.橙色 -> R.style.Kurumi_Green_Orange
                颜色.暗橙 -> R.style.Kurumi_Green_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Green_Brown
                颜色.灰色 -> R.style.Kurumi_Green_Green
                颜色.蓝灰 -> R.style.Kurumi_Green_BlueGrey
                else -> null
            }
            颜色.亮绿 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_LightGreen_Red
                颜色.粉色 -> R.style.Kurumi_LightGreen_Pink
                颜色.紫色 -> R.style.Kurumi_LightGreen_Purple
                颜色.深紫 -> R.style.Kurumi_LightGreen_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_LightGreen_Indigo
                颜色.蓝色 -> R.style.Kurumi_LightGreen_Blue
                颜色.亮蓝 -> R.style.Kurumi_LightGreen_LightBlue
                颜色.青色 -> R.style.Kurumi_LightGreen_Cyan
                颜色.鸭绿 -> R.style.Kurumi_LightGreen_Teal
                颜色.绿色 -> R.style.Kurumi_LightGreen_Green
                颜色.亮绿 -> R.style.Kurumi_LightGreen_LightGreen
                颜色.酸橙 -> R.style.Kurumi_LightGreen_Lime
                颜色.黄色 -> R.style.Kurumi_LightGreen_Yellow
                颜色.琥珀 -> R.style.Kurumi_LightGreen_Amber
                颜色.橙色 -> R.style.Kurumi_LightGreen_Orange
                颜色.暗橙 -> R.style.Kurumi_LightGreen_DeepOrange
                颜色.棕色 -> R.style.Kurumi_LightGreen_Brown
                颜色.灰色 -> R.style.Kurumi_LightGreen_Green
                颜色.蓝灰 -> R.style.Kurumi_LightGreen_BlueGrey
                else -> null
            }
            颜色.酸橙 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Lime_Red
                颜色.粉色 -> R.style.Kurumi_Lime_Pink
                颜色.紫色 -> R.style.Kurumi_Lime_Purple
                颜色.深紫 -> R.style.Kurumi_Lime_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Lime_Indigo
                颜色.蓝色 -> R.style.Kurumi_Lime_Blue
                颜色.亮蓝 -> R.style.Kurumi_Lime_LightBlue
                颜色.青色 -> R.style.Kurumi_Lime_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Lime_Teal
                颜色.绿色 -> R.style.Kurumi_Lime_Green
                颜色.亮绿 -> R.style.Kurumi_Lime_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Lime_Lime
                颜色.黄色 -> R.style.Kurumi_Lime_Yellow
                颜色.琥珀 -> R.style.Kurumi_Lime_Amber
                颜色.橙色 -> R.style.Kurumi_Lime_Orange
                颜色.暗橙 -> R.style.Kurumi_Lime_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Lime_Brown
                颜色.灰色 -> R.style.Kurumi_Lime_Green
                颜色.蓝灰 -> R.style.Kurumi_Lime_BlueGrey
                else -> null
            }
            颜色.黄色 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Yellow_Red
                颜色.粉色 -> R.style.Kurumi_Yellow_Pink
                颜色.紫色 -> R.style.Kurumi_Yellow_Purple
                颜色.深紫 -> R.style.Kurumi_Yellow_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Yellow_Indigo
                颜色.蓝色 -> R.style.Kurumi_Yellow_Blue
                颜色.亮蓝 -> R.style.Kurumi_Yellow_LightBlue
                颜色.青色 -> R.style.Kurumi_Yellow_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Yellow_Teal
                颜色.绿色 -> R.style.Kurumi_Yellow_Green
                颜色.亮绿 -> R.style.Kurumi_Yellow_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Yellow_Lime
                颜色.黄色 -> R.style.Kurumi_Yellow_Yellow
                颜色.琥珀 -> R.style.Kurumi_Yellow_Amber
                颜色.橙色 -> R.style.Kurumi_Yellow_Orange
                颜色.暗橙 -> R.style.Kurumi_Yellow_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Yellow_Brown
                颜色.灰色 -> R.style.Kurumi_Yellow_Green
                颜色.蓝灰 -> R.style.Kurumi_Yellow_BlueGrey
                else -> null
            }
            颜色.琥珀 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Amber_Red
                颜色.粉色 -> R.style.Kurumi_Amber_Pink
                颜色.紫色 -> R.style.Kurumi_Amber_Purple
                颜色.深紫 -> R.style.Kurumi_Amber_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Amber_Indigo
                颜色.蓝色 -> R.style.Kurumi_Amber_Blue
                颜色.亮蓝 -> R.style.Kurumi_Amber_LightBlue
                颜色.青色 -> R.style.Kurumi_Amber_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Amber_Teal
                颜色.绿色 -> R.style.Kurumi_Amber_Green
                颜色.亮绿 -> R.style.Kurumi_Amber_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Amber_Lime
                颜色.黄色 -> R.style.Kurumi_Amber_Yellow
                颜色.琥珀 -> R.style.Kurumi_Amber_Amber
                颜色.橙色 -> R.style.Kurumi_Amber_Orange
                颜色.暗橙 -> R.style.Kurumi_Amber_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Amber_Brown
                颜色.灰色 -> R.style.Kurumi_Amber_Green
                颜色.蓝灰 -> R.style.Kurumi_Amber_BlueGrey
                else -> null
            }
            颜色.橙色 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Orange_Red
                颜色.粉色 -> R.style.Kurumi_Orange_Pink
                颜色.紫色 -> R.style.Kurumi_Orange_Purple
                颜色.深紫 -> R.style.Kurumi_Orange_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Orange_Indigo
                颜色.蓝色 -> R.style.Kurumi_Orange_Blue
                颜色.亮蓝 -> R.style.Kurumi_Orange_LightBlue
                颜色.青色 -> R.style.Kurumi_Orange_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Orange_Teal
                颜色.绿色 -> R.style.Kurumi_Orange_Green
                颜色.亮绿 -> R.style.Kurumi_Orange_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Orange_Lime
                颜色.黄色 -> R.style.Kurumi_Orange_Yellow
                颜色.琥珀 -> R.style.Kurumi_Orange_Amber
                颜色.橙色 -> R.style.Kurumi_Orange_Orange
                颜色.暗橙 -> R.style.Kurumi_Orange_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Orange_Brown
                颜色.灰色 -> R.style.Kurumi_Orange_Green
                颜色.蓝灰 -> R.style.Kurumi_Orange_BlueGrey
                else -> null
            }
            颜色.暗橙 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_DeepOrange_Red
                颜色.粉色 -> R.style.Kurumi_DeepOrange_Pink
                颜色.紫色 -> R.style.Kurumi_DeepOrange_Purple
                颜色.深紫 -> R.style.Kurumi_DeepOrange_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_DeepOrange_Indigo
                颜色.蓝色 -> R.style.Kurumi_DeepOrange_Blue
                颜色.亮蓝 -> R.style.Kurumi_DeepOrange_LightBlue
                颜色.青色 -> R.style.Kurumi_DeepOrange_Cyan
                颜色.鸭绿 -> R.style.Kurumi_DeepOrange_Teal
                颜色.绿色 -> R.style.Kurumi_DeepOrange_Green
                颜色.亮绿 -> R.style.Kurumi_DeepOrange_LightGreen
                颜色.酸橙 -> R.style.Kurumi_DeepOrange_Lime
                颜色.黄色 -> R.style.Kurumi_DeepOrange_Yellow
                颜色.琥珀 -> R.style.Kurumi_DeepOrange_Amber
                颜色.橙色 -> R.style.Kurumi_DeepOrange_Orange
                颜色.暗橙 -> R.style.Kurumi_DeepOrange_DeepOrange
                颜色.棕色 -> R.style.Kurumi_DeepOrange_Brown
                颜色.灰色 -> R.style.Kurumi_DeepOrange_Green
                颜色.蓝灰 -> R.style.Kurumi_DeepOrange_BlueGrey
                else -> null
            }
            颜色.棕色 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Brown_Red
                颜色.粉色 -> R.style.Kurumi_Brown_Pink
                颜色.紫色 -> R.style.Kurumi_Brown_Purple
                颜色.深紫 -> R.style.Kurumi_Brown_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Brown_Indigo
                颜色.蓝色 -> R.style.Kurumi_Brown_Blue
                颜色.亮蓝 -> R.style.Kurumi_Brown_LightBlue
                颜色.青色 -> R.style.Kurumi_Brown_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Brown_Teal
                颜色.绿色 -> R.style.Kurumi_Brown_Green
                颜色.亮绿 -> R.style.Kurumi_Brown_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Brown_Lime
                颜色.黄色 -> R.style.Kurumi_Brown_Yellow
                颜色.琥珀 -> R.style.Kurumi_Brown_Amber
                颜色.橙色 -> R.style.Kurumi_Brown_Orange
                颜色.暗橙 -> R.style.Kurumi_Brown_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Brown_Brown
                颜色.灰色 -> R.style.Kurumi_Brown_Green
                颜色.蓝灰 -> R.style.Kurumi_Brown_BlueGrey
                else -> null
            }
            颜色.灰色 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_Green_Red
                颜色.粉色 -> R.style.Kurumi_Green_Pink
                颜色.紫色 -> R.style.Kurumi_Green_Purple
                颜色.深紫 -> R.style.Kurumi_Green_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_Green_Indigo
                颜色.蓝色 -> R.style.Kurumi_Green_Blue
                颜色.亮蓝 -> R.style.Kurumi_Green_LightBlue
                颜色.青色 -> R.style.Kurumi_Green_Cyan
                颜色.鸭绿 -> R.style.Kurumi_Green_Teal
                颜色.绿色 -> R.style.Kurumi_Green_Green
                颜色.亮绿 -> R.style.Kurumi_Green_LightGreen
                颜色.酸橙 -> R.style.Kurumi_Green_Lime
                颜色.黄色 -> R.style.Kurumi_Green_Yellow
                颜色.琥珀 -> R.style.Kurumi_Green_Amber
                颜色.橙色 -> R.style.Kurumi_Green_Orange
                颜色.暗橙 -> R.style.Kurumi_Green_DeepOrange
                颜色.棕色 -> R.style.Kurumi_Green_Brown
                颜色.灰色 -> R.style.Kurumi_Green_Green
                颜色.蓝灰 -> R.style.Kurumi_Green_BlueGrey
                else -> null
            }
            颜色.蓝灰 -> when (颜色.强调) {
                颜色.红色 -> R.style.Kurumi_BlueGrey_Red
                颜色.粉色 -> R.style.Kurumi_BlueGrey_Pink
                颜色.紫色 -> R.style.Kurumi_BlueGrey_Purple
                颜色.深紫 -> R.style.Kurumi_BlueGrey_DeepPurple
                颜色.靛蓝 -> R.style.Kurumi_BlueGrey_Indigo
                颜色.蓝色 -> R.style.Kurumi_BlueGrey_Blue
                颜色.亮蓝 -> R.style.Kurumi_BlueGrey_LightBlue
                颜色.青色 -> R.style.Kurumi_BlueGrey_Cyan
                颜色.鸭绿 -> R.style.Kurumi_BlueGrey_Teal
                颜色.绿色 -> R.style.Kurumi_BlueGrey_Green
                颜色.亮绿 -> R.style.Kurumi_BlueGrey_LightGreen
                颜色.酸橙 -> R.style.Kurumi_BlueGrey_Lime
                颜色.黄色 -> R.style.Kurumi_BlueGrey_Yellow
                颜色.琥珀 -> R.style.Kurumi_BlueGrey_Amber
                颜色.橙色 -> R.style.Kurumi_BlueGrey_Orange
                颜色.暗橙 -> R.style.Kurumi_BlueGrey_DeepOrange
                颜色.棕色 -> R.style.Kurumi_BlueGrey_Brown
                颜色.灰色 -> R.style.Kurumi_BlueGrey_Green
                颜色.蓝灰 -> R.style.Kurumi_BlueGrey_BlueGrey
                else -> null
            }
            else -> null
        }.applyIfNotNull {
            setTheme(this)
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>?, grantResults: IntArray?) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        权限监听器.remove(requestCode).applyIfNotNull {

            val _结果 = HashMap<String, Boolean>()
            permissions?.forEachIndexed { index, permstr ->
                _结果.put(permstr, grantResults?.get(index) == PackageManager.PERMISSION_GRANTED)
            }

            invoke(_结果)

        }

    }

    override fun 显示() {
    }

    override fun 子界面(_界面: KClass<out 界面>) {

        val _意图 = Intent(this, KurumiActivity::class.java)
        _意图.putExtra("_界面", _界面.java)
        startActivity(_意图)

    }

    override fun 视图(): 视图 {
        return 安卓视图(this)
    }

    override fun 布局(): 布局 {
        return 安卓布局(this)
    }

    override fun 垂直布局(): 线性布局 {
        return 安卓线性布局.垂直(this)
    }

    override fun 水平布局(): 线性布局 {
        return 安卓线性布局.水平(this)
    }

    override fun 文本视图(): 文本视图 {
        return 安卓文本视图(this)
    }

    override fun 按钮(): 按钮 {
        return 安卓按钮(this)
    }

    override fun 图片视图(): 图片视图 {
        return 安卓图片视图(this)
    }

    override fun 编辑框(): 编辑框 {
        return 安卓编辑框(this)
    }

}
