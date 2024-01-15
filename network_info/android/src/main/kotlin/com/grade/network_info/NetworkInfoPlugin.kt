package com.grade.network_info

import androidx.annotation.NonNull
import android.content.Context
import android.net.* 
import android.net.wifi.WifiManager
import android.os.Build
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding


/** NetworkInfoPlugin */
class NetworkInfoPlugin: FlutterPlugin {
  private lateinit var channel : MethodChannel

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "network_info")

    val networkInfo = NetworkInfo()
    networkInfo.create(flutterPluginBinding.applicationContext)

    val methodCallHandler = NetworkInfoMethodChannelHandler(networkInfo) 
    channel.setMethodCallHandler(methodCallHandler)
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}
