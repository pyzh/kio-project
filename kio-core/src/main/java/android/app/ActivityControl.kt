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
