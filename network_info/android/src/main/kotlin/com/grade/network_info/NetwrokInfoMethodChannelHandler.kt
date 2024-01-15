package com.grade.network_info

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler

internal class NetworkInfoMethodChannelHandler(private val networkInfo: NetworkInfo) : MethodCallHandler {
    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
        when(call.method) {
            "getNetworkType" -> result.success(networkInfo.networkType()) 
            else -> result.notImplemented()
        }
    }
}