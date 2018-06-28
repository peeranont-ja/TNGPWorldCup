package com.example.tnis.tngpworldcup

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tnis.tngpworldcup.Datamanager.DataManager
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {

    private val dataManager = DataManager()

    companion object {
        fun newInstance(): DetailFragment {
            return DetailFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_detail,
                container, false)
}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView(){
        val options = RequestOptions().fitCenter()

        Glide.with(context!!)
                .load(dataManager.getFlagURL("RUS"))
                .apply(options)
                .into(image_home_team)

        Glide.with(context!!)
                .load(dataManager.getFlagURL("KSA"))
                .apply(options)
                .into(image_away_team)
    }
}