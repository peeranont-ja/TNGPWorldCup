package com.example.tnis.tngpworldcup.datamanager.model

import android.os.Parcel
import android.os.Parcelable

open class Match(var matchNo: Int = 0,
                 var matchType: String? = null,
                 var startTimeStamp: String? = null,
                 var homeTeamShortName: String? = null,
                 var awayTeamShortName: String? = null,
                 var homeTeamName: String? = null,
                 var awayTeamName: String? = null,
                 var homeScore: Int = 0,
                 var awayScore: Int = 0) : Parcelable {


    constructor(parcel: Parcel) : this() {
        matchNo = parcel.readInt()
        matchType = parcel.readString()
        startTimeStamp = parcel.readString()
        homeTeamShortName = parcel.readString()
        awayTeamShortName = parcel.readString()
        homeTeamName = parcel.readString()
        awayTeamName = parcel.readString()
        homeScore = parcel.readInt()
        awayScore = parcel.readInt()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(matchNo)
        parcel.writeString(matchType)
        parcel.writeString(startTimeStamp)
        parcel.writeString(homeTeamShortName)
        parcel.writeString(awayTeamShortName)
        parcel.writeString(homeTeamName)
        parcel.writeString(awayTeamName)
        parcel.writeInt(homeScore)
        parcel.writeInt(awayScore)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Match> {
        override fun createFromParcel(parcel: Parcel): Match {
            return Match(parcel)
        }

        override fun newArray(size: Int): Array<Match?> {
            return arrayOfNulls(size)
        }
    }
}