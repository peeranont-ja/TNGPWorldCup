package com.example.tnis.tngpworldcup.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tnis.tngpworldcup.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add MainFragment to MainActivity

        if(savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commit()
        }

    }
}



