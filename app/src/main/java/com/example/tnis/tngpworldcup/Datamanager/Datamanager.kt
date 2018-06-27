package com.example.tnis.tngpworldcup.Datamanager

import android.util.Log
import android.widget.Toast
import com.example.tnis.tngpworldcup.Datamanager.Model.Match
import com.example.tnis.tngpworldcup.Datamanager.Remote.ServiceFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Datamanager(){

    fun getMockFlag(): Array<String> = arrayOf(
            "http://mblc."
    )

    fun getMatchInfo(): Call<List<Match>> =  ServiceFactory.worldCupService().getMatchInfo()

    fun getMockMatchInfo(): Array<Match> = arrayOf(
            Match(1,
                    "Group A",
                    "2018-06-14T15:00:00.000Z",
                    "RUS",
                    "URU",
                    "Russia",
                    "Uruguay",
                    2,
                    10),
            Match(2,
                    "Group B",
                    "2018-06-15T15:25:00.000Z",
                    "MAR",
                    "URU",
                    "Morocco",
                    "Uruguay",
                    2,
                    10),
            Match(3,
                    "Group C",
                    "2018-06-16T19:00:00.000Z",
                    "GER",
                    "MEX",
                    "Germany",
                    "Mexico",
                    4,
                    4),
            Match(4,
                    "Group D",
                    "2018-06-17T20:00:00.000Z",
                    "TUN",
                    "JPN",
                    "Tunisia",
                    "Japan",
                    2,
                    1)
    )

}