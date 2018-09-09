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

package io.kurumi.desktop.service

import io.kurumi.desktop.ui.view.桌面布局
import io.kurumi.desktop.ui.view.桌面文本视图
import io.kurumi.desktop.ui.view.桌面线性布局
import io.kurumi.desktop.ui.view.桌面视图
import io.kurumi.desktop.桌面界面
import javafx.application.Platform

object 桌面界面服务 : 上下文 {

    override fun 主线程处理(_执行: () -> Unit) {
        Platform.runLater(_执行)
    }

    override fun 启动界面(_上下文: 上下文, _界面: Class<out 界面>) {
        桌面界面.启动界面(_上下文, _界面)
    }

    override fun 新视图实现(_上下文: 上下文): 基本视图 {
        return 桌面视图(_上下文)
    }

    override fun 新布局实现(_上下文: 上下文): 基本布局 {
        return 桌面布局(_上下文)
    }

    override fun 新垂直布局(_上下文: 上下文): 基本线性布局.垂直 {
        return 桌面线性布局.垂直(_上下文)
    }

    override fun 新水平布局(_上下文: 上下文): 基本线性布局.水平 {
        return 桌面线性布局.水平(_上下文)
    }

    override fun 新文本视图实现(_上下文: 上下文): 基本文本 {
        return 桌面文本视图(_上下文)
    }


}