package com.example.tnis.tngpworldcup.utils

import java.text.SimpleDateFormat
import java.util.*

class DataFormatter {

    companion object {
        fun convertIsoToLocalDateTime(stringIsoDate: String): String {
            //    date input: 2018-06-15T18:00:00.000Z
            //    date output: Sat 16 Jun 2018  01:00
            return try {
                val isoDateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                isoDateFormatter.timeZone = TimeZone.getTimeZone("UTC")
                val date = isoDateFormatter.parse(stringIsoDate.trim())
                val simpleDateFormatter = SimpleDateFormat("E dd MMM yyyy  HH:mm")
                simpleDateFormatter.format(date)
            } catch (e:Exception){
                "Convert failed."
            }
        }
    }

}