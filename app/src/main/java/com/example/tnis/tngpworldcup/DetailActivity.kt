package com.example.tnis.tngpworldcup

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbar.title = "ข้อมูลการแข่งขัน"


        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, DetailFragment.newInstance())
                .commit()
    }


}