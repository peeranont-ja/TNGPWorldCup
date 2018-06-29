package com.example.tnis.tngpworldcup.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tnis.tngpworldcup.R
import kotlinx.android.synthetic.main.activity_detail.*

class MatchListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        //Modify the toolbar
        //Change toolbar title
        toolbar.title = "ข้อมูลการแข่งขัน"

        //Set up Back button
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        //Add MatchListFragment to MatchListActivity
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MatchListFragment.newInstance())
                .commit()
    }

    //Override function for defining action of Back button
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}