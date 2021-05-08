package com.reposenergy.common

import android.content.Context
import android.net.ConnectivityManager

class AppUtils(private val mContext: Context) {

    companion object {
        /**
         * Check internet is connected or not
         */
        fun isNetworkConnected(context: Context?): Boolean {
            var isConnected = false
            if (context == null) return false
            val connectivityManager = context
                .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                val networkInfo = connectivityManager.allNetworkInfo
                if (networkInfo != null) {
                    for (aNetworkInfo in networkInfo) {
                        if (aNetworkInfo.isConnected) {
                            isConnected = true
                            break
                        }
                    }
                }
            }
            return isConnected
        }
    }
}