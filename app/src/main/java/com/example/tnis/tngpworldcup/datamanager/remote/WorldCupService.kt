package com.example.tnis.tngpworldcup.datamanager.remote

import com.example.tnis.tngpworldcup.datamanager.remote.model.MatchResponse
import retrofit2.Call
import retrofit2.http.GET

interface WorldCupService {

    @GET("api/matches")
    fun getMatchInfo(): Call<List<MatchResponse>>

}