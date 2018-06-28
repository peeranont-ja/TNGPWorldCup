package com.example.tnis.tngpworldcup.datamanager

import com.example.tnis.tngpworldcup.datamanager.model.Match
import com.example.tnis.tngpworldcup.datamanager.remote.model.MatchResponse
import com.example.tnis.tngpworldcup.datamanager.remote.ServiceFactory

class DataManager {

    fun getFlagURL(country: String): String = "https://mblwc.cleverapps.io/images/$country.png"

    fun getMatchInfo(): retrofit2.Call<List<MatchResponse>> =  ServiceFactory.worldCupService().getMatchInfo()

    fun getMockMatchInfo(): List<Match> = listOf(
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