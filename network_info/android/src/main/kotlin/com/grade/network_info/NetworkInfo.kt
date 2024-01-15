
package com.grade.network_info

import android.net.ConnectivityManager
import android.os.Build
import java.net.*


internal class NetworkInfo(private val cm: ConnectivityManager? = null) { 
    // var cm : ConnectivityManager? = null; 

    // fun create() {
    //     if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { 
    //         cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager;
    //     }
    // }

    public fun networkType() : String =
       cm?.getActiveNetworkInfo()?.getTypeName() ?: "Cannot get network info"
}