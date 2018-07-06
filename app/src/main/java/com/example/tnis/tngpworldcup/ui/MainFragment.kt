package com.example.tnis.tngpworldcup.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.tnis.tngpworldcup.R
import kotlinx.android.synthetic.main.fragment_main.*

//Extend Fragment
class MainFragment : Fragment() {

    //Static Method for Activity to call new instance
    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    //Link XML to the fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main,
                container, false)
    }

    //Set up view actions when view is already created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInstance()
    }

    //Function to define view actions
    private fun initInstance() {
        //Use Glide to display image from URL show in view ID name's "fullscreen_background"
        Glide.with(context!!)
                .load("https://img.aws.livestrongcdn.com/" +
                        "ls-article-image-673/ds-photo/getty/article/190/90/118254260.jpg")
                .into(img_fullscreen_background)

        btn_play.setOnClickListener {
            //Show Progress bar
            progress_bar.visibility = View.VISIBLE

            //Disable Button for preventing several clicks
            btn_play.isEnabled = false

            goToNextPage()
        }
    }

    //Spin off function to make code easy to understand the flow
    private fun goToNextPage() {
        //Add delay to show the Progress bar before intent to next page
        Handler().postDelayed({
            //Actions after delay

            //Enable button
            btn_play.isEnabled = true

            //Intent to next page
            val intent = Intent(activity, MatchListActivity::class.java)
            startActivity(intent)

            //Hide Progress bar
            progress_bar.visibility = View.GONE

        }, 1500) //Delay time is in a millisecond unit
    }
}