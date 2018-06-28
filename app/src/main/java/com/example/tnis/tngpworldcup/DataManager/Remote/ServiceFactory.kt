package com.example.tnis.tngpworldcup.DataManager.Remote

import com.example.tnis.tngpworldcup.DataManager.Interceptor.LogJsonInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceFactory {
    companion object {
        fun worldCupService() : WorldCupService  {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(LogJsonInterceptor())
            val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl("https://mblwc.cleverapps.io/")
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .client(httpClient.build())
                    .build()
            return retrofit.create(WorldCupService::class.java)
        }
    }
}