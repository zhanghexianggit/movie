package com.bw.baselibrary.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.telephony.TelephonyManager

/**
 *@Author:AbnerMing
 *@Description:网络判断工具类
 *@Date:2019/9/20 9:06
 */

class NetworkUtils() {
    companion object {


        var networkMessage = "网络开小差了，请检查网络！"
        /**
         * 获取当前网络连接信息
         *
         * @param paramContext
         * @return
         */
        fun getActiveNetworkInfo(paramContext: Context): NetworkInfo? {
            return (paramContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
        }

        /**
         * 获取当前连接网络类型
         *
         * @param paramContext
         * @return
         */
        fun getNetworkType(paramContext: Context): Int {
            val localConnectivityManager =
                paramContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (localConnectivityManager != null) {
                val localNetworkInfo = localConnectivityManager.activeNetworkInfo
                if (localNetworkInfo != null)
                    return localNetworkInfo.type
            }
            return -1
        }

        /**
         * 检测是否使用3G/4G
         *
         * @param paramContext
         * @return
         */
        @SuppressLint("WrongConstant")
        fun is3Gor4G(paramContext: Context): Boolean {
            try {
                val i = (paramContext.getSystemService("phone") as TelephonyManager).networkType
                if (i == 8 || i == 13 || i == 3 || i == 15 || i == 10 || i == 14 || i == 6 || i == 9 || i == 12)
                    return true
            } catch (localException: Exception) {
            }

            return false
        }

        /**
         * 检测网络类型是否为移动数据连接
         *
         * @param paramNetworkInfo
         * @return
         */
        fun isMobileNetworkInfo(paramNetworkInfo: NetworkInfo): Boolean {
            return paramNetworkInfo.type == 0 || 50 == paramNetworkInfo.type
        }

        /**
         * 检测是否支持网络
         *
         * @param paramContext
         * @return
         */
        fun isNetSupprot(paramContext: Context): Boolean {
            val localConnectivityManager =
                paramContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                    ?: return false
            try {
                val arrayOfNetworkInfo = localConnectivityManager.allNetworkInfo
                if (arrayOfNetworkInfo != null) {
                    for (i in arrayOfNetworkInfo.indices) {
                        val localState1 = arrayOfNetworkInfo[i].state
                        val localState2 = NetworkInfo.State.CONNECTED
                        if (localState1 == localState2)
                            return true
                    }
                }
            } catch (e: Exception) {
                // TODO: handle exception
                e.printStackTrace()
            }

            return false
        }

        /**
         * 检测是否使用移动数据
         *
         * @param paramContext
         * @return
         */
        fun isNetworkAvailable(paramContext: Context): Boolean {
            val localNetworkInfo =
                (paramContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
            return localNetworkInfo != null && localNetworkInfo.isAvailable
        }

        /**
         * 检测是否开启wifi
         *
         * @param paramContext
         * @return
         */
        @SuppressLint("DefaultLocale")
        fun isWifiEnabled(paramContext: Context): Boolean {
            try {
                val localNetworkInfo =
                    (paramContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
                return localNetworkInfo!!.typeName.toLowerCase() == "wifi"
            } catch (e: Exception) {
                // TODO: handle exception
            }

            return false
        }

        /**
         * 检测是否通过wifi连接
         *
         * @param paramContext
         * @return
         */
        fun isWifiConnected(paramContext: Context): Boolean {
            val localNetworkInfo =
                (paramContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo
            return localNetworkInfo != null && localNetworkInfo.type == 1
        }

        /**
         * 检查是否连接网络
         *
         * @param context
         * @return
         */
        fun isConnected(context: Context): Boolean {
            val connectMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val mobNetInfo = connectMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
            val wifiNetInfo = connectMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            if (mobNetInfo != null && mobNetInfo.isConnected) {
                return true
            }
            return if (wifiNetInfo != null && wifiNetInfo.isConnected) {
                true
            } else false
        }

    }
}