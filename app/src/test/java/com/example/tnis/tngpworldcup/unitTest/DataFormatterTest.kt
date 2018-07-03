package com.example.tnis.tngpworldcup.unitTest

import com.example.tnis.tngpworldcup.utils.DataFormatter
import org.junit.Assert
import org.junit.Test

class DataFormatterTest {

    @Test
    fun `Test convert iso8601 to local DateTime`(){
        Assert.assertEquals("Sat 16 Jun 2018  01:00",
                DataFormatter.convertIsoToLocalDateTime("2018-06-15T18:00:00.000Z"))
        Assert.assertEquals("Sat 16 Jun 2018  01:00",
                DataFormatter.convertIsoToLocalDateTime("   2018-06-15T18:00:00.000Z   "))
        Assert.assertEquals("Convert failed.",
                DataFormatter.convertIsoToLocalDateTime("2018-06-15T18:00:00.000"))
        Assert.assertEquals("Convert failed.",
                DataFormatter.convertIsoToLocalDateTime("2018-06-15"))
        Assert.assertEquals("Convert failed.",
                DataFormatter.convertIsoToLocalDateTime(""))
        Assert.assertEquals("Convert failed.",
                DataFormatter.convertIsoToLocalDateTime(" "))
    }

}