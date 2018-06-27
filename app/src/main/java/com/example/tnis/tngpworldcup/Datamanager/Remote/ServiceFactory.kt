package com.example.tnis.tngpworldcup.Datamanager.Remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServiceFactory {
    companion object {
        fun worldCupService() : WorldCupService  {
            val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl("https://mblwc.cleverapps.io/")
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .build()
            return retrofit.create(WorldCupService::class.java)
        }
    }
}