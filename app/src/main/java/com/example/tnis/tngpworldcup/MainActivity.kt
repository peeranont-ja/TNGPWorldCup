package com.example.tnis.tngpworldcup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.tnis.tngpworldcup.datamanager.model.Match
import retrofit2.Call
import android.widget.Toast
import com.example.tnis.tngpworldcup.datamanager.DataManager
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commit()

    }
}



