package com.example.tnis.tngpworldcup.Datamanager.Remote

import com.example.tnis.tngpworldcup.Datamanager.Model.Match
import kotlin.collections.List
import retrofit2.http.GET
import retrofit2.Call
interface WorldCupService {

    @GET("api/matches")
    fun getMatchInfo(): Call<List<Match>>

}