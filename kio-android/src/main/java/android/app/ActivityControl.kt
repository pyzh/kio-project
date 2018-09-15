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

package android.app

import android.app.ActivityThread.ActivityClientRecord
import android.os.IBinder
import android.util.ArrayMap
import cn.hutool.core.util.ReflectUtil

import java.lang.reflect.Field
import java.util.*

/**
 * 对ActivityThread.ActivityClientRecord的操作 (同包下)
 */

object ActivityControl {

    private var mActivities: Field = ReflectUtil.getField(ActivityThread::class.java, "mActivities")

    val currentActivity: Activity?
        get() {
            for ((_, value) in activityRecordsMap) {
                if (!value.stopped) {
                    return value.activity
                }
            }
            return null
        }

    val activities: Array<Activity>
        get() {
            val al = LinkedList<Activity>()
            for ((_, value) in activityRecordsMap) {
                al.add(value.activity)
            }
            return al.toTypedArray()
        }

    private val activityRecordsMap: ArrayMap<IBinder, ActivityClientRecord>
        get() {
            try {
                return mActivities.get(ActivityThread.currentActivityThread()) as ArrayMap<IBinder, ActivityClientRecord>
            } catch (e: Exception) {
                throw RuntimeException(e)
            }

        }

    fun finishAll() {
        activityRecordsMap.forEach {
            it.value.activity.finish()
        }
    }

}
