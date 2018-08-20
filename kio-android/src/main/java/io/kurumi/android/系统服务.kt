package io.kurumi.android

import android.content.ClipboardManager
import android.content.Context

object 系统服务 {

    //var 下载管理 = 取系统服务<DownloadManager>(Context.DOWNLOAD_SERVICE)
    var 剪切板 = 取系统服务<ClipboardManager>(Context.CLIPBOARD_SERVICE)
    //var 设备管理 = 取系统服务<TelephonyManager>(Context.TELEPHONY_SERVICE)
    //var 震动 = 取系统服务<Vibrator>(Context.VIBRATOR_SERVICE)
    //var 壁纸管理 = 取系统服务<WallpaperManager>(Context.WALLPAPER_SERVICE)
    var 屏幕信息 = 安卓应用.实例.getResources().getDisplayMetrics()
    //var 电量管理 = 取系统服务<BatteryManager>(Context.BATTERY_SERVICE)
    //var 音频管理 = 取系统服务<AudioManager>(Context.AUDIO_SERVICE)
    //var 网络管理 = 取系统服务<ConnectivityManager>(Context.CONNECTIVITY_SERVICE)
    //var WIFI管理 = 取系统服务<WifiManager>(Context.WIFI_SERVICE)
    //var WIFI信息 = 网络管理.getNetworkInfo(ConnectivityManager.TYPE_WIFI)


    fun <系统服务> 取系统服务(_服务: String): 系统服务 {
        @Suppress("UNCHECKED_CAST")
        return 安卓应用.实例.getSystemService(_服务) as 系统服务
    }

}
