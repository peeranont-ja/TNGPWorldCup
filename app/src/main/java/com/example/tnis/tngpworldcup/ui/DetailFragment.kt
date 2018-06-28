package com.example.tnis.tngpworldcup.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tnis.tngpworldcup.R
import com.example.tnis.tngpworldcup.datamanager.DataManager
import com.example.tnis.tngpworldcup.datamanager.model.Match
import kotlinx.android.synthetic.main.fragment_detail.*
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.*


class DetailFragment : Fragment() {

    private val dataManager = DataManager()
    private lateinit var matchInfo: Match

    companion object {
        fun newInstance(matchInfo: Match): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putParcelable("matchInfo", matchInfo)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        matchInfo = arguments!!.getParcelable("matchInfo")
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

        val isoFormat = (DateTimeFormatter.ISO_DATE_TIME)
        val matchDate = LocalDateTime.parse(matchInfo.startTimeStamp, isoFormat).plusHours(7)
        val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        val formattedDate = matchDate.format(dateFormat)

        Glide.with(context!!)
                .load(dataManager.getFlagURL(matchInfo.homeTeamShortName!!))
                .apply(options)
                .into(image_flag_home_team)

        Glide.with(context!!)
                .load(dataManager.getFlagURL(matchInfo.awayTeamShortName!!))
                .apply(options)
                .into(image_flag_away_team)

        text_group_name.text = matchInfo.matchType
        text_home_team_name.text = matchInfo.homeTeamName
        text_away_team_name.text = matchInfo.awayTeamName
        text_start_time.text = formattedDate
        text_score.text = "${matchInfo.homeScore} : ${matchInfo.awayScore}"
    }
}