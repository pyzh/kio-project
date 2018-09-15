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

package io.kurumi.android.app

import android.os.Bundle
import io.kurumi.android.安卓界面
import io.kurumi.app.content.界面

class KurumiActivity : 安卓界面() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @Suppress("UNCHECKED_CAST")
        val clazz = intent.getSerializableExtra("_界面") as Class<out 界面>?
        if (clazz != null) {
            val _界面 = clazz.newInstance()
            _界面.实现 = this
            _界面.界面创建事件()
        } else {
            finish()
        }
    }
}