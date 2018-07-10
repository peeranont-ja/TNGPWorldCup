package com.example.tnis.tngpworldcup.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.tnis.tngpworldcup.R
import com.example.tnis.tngpworldcup.datamanager.model.Match
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val intent = intent
        val matchInfo = intent.getParcelableExtra<Match>("matchInfo")

        toolbar.title = "รายละเอียดการแข่งขัน"
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        if(savedInstanceState == null ) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.container, DetailFragment.newInstance(matchInfo))
                    .commit()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}