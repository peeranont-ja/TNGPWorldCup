package com.example.tnis.tngpworldcup.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.tnis.tngpworldcup.R
import kotlinx.android.synthetic.main.activity_detail.*

class MatchListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbar.title = "ข้อมูลการแข่งขัน"
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, MatchListFragment.newInstance())
                .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}