package com.example.tnis.tngpworldcup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

import com.example.tnis.tngpworldcup.Datamanager.Model.Match
import com.example.tnis.tngpworldcup.Datamanager.Remote.ServiceFactory

import com.example.tnis.tngpworldcup.Datamanager.Remote.WorldCupService

import retrofit2.Call
import android.widget.Toast
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


        val service = ServiceFactory.worldCupService()
        val call : Call<List<Match>> = service.getMatchInfo()
        Log.wtf("URL Called", call.request().url().toString());
        call.enqueue(object : Callback<List<Match>> {
            override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
               Log.d("retrofit",response.body().toString())
            }

            override  fun onFailure(call: Call<List<Match>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong...Error message: " + t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}



