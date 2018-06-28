package com.example.tnis.tngpworldcup.DataManager.Model

import com.google.gson.annotations.SerializedName

data class Match(
        @SerializedName("match_no") val matchNo: Int,
        @SerializedName("match_type") val matchType: String,
        @SerializedName("start_timestamp") val startTimeStamp: String,
        @SerializedName("home_team") val homeTeamShortName: String,
        @SerializedName("away_team") val awayTeamShortName: String,
        @SerializedName("home_team_name") val homeTeamName: String,
        @SerializedName("away_team_name") val awayTeamName: String,
        @SerializedName("home_score") val homeScore: Int,
        @SerializedName("away_score") val awayScore: Int
)