package com.example.tnis.tngpworldcup.Datamanager.Remote

import retrofit2.Retrofit

class ServiceFactory {

    private val worldCupService: WorldCupService
    init {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("https://mblwc.cleverapps.io/")
                .build()
        worldCupService = retrofit.create(WorldCupService::class.java)
    }
}