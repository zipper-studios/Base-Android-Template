package com.base_android_template.shared.network

import android.Manifest.permission.ACCESS_NETWORK_STATE
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission

class NetworkHandler constructor(private val connectivityManager: ConnectivityManager) {

    @RequiresPermission(ACCESS_NETWORK_STATE)
    fun hasNetworkConnection(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val networkConnection =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            hasNetworkConnection(networkConnection)
        } else {
            val networkInfo = connectivityManager.activeNetworkInfo
            hasNetworkConnection(networkInfo)
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private fun hasNetworkConnection(networkCapabilities: NetworkCapabilities?): Boolean {
        return networkCapabilities != null && (networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || networkCapabilities.hasTransport(
            NetworkCapabilities.TRANSPORT_CELLULAR
        ))
    }

    private fun hasNetworkConnection(networkInfo: NetworkInfo?): Boolean {
        return networkInfo != null && networkInfo.isConnected
    }
}