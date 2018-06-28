package com.example.tnis.tngpworldcup

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_main,
                container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() {
        //Use Glide to display image from URL show in view ID name's "fullscreen_background"
        Glide.with(context!!)
                .load("https://img.aws.livestrongcdn.com/" +
                        "ls-article-image-673/ds-photo/getty/article/190/90/118254260.jpg")
                .into(fullscreen_background)

        btn_play.setOnClickListener {
            //Show Progress bar
            progressBar.visibility = View.VISIBLE

            //Disable Button for preventing several clicks
            btn_play.isEnabled = false

            goToNextPage()
        }
    }

    private fun goToNextPage() {
        //Add delay to show the Progress bar before intent to next page
        Handler().postDelayed({
            //Actions after delay

            //Enable button
            btn_play.isEnabled = true

            //Intent to next page
            val intent = Intent(activity, DetailActivity::class.java)
            startActivity(intent)

            //Hide Progress bar
            progressBar.visibility = View.GONE

        }, 1500)
    }
}