package com.example.tnis.tngpworldcup.Datamanager.Interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody

class LogJsonInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response  {
        val request: Request? = chain?.request()
        val response: Response? = chain?.proceed(request)
        val rawJson: String = response?.body()!!.string()
        Log.d("Intercep: ", String.format("raw JSON response is: %s", rawJson))
        return response.newBuilder()
                .body(ResponseBody.create(response.body()!!.contentType(), rawJson))
                .build()
    }

}