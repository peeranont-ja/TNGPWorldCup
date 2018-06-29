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
import java.text.SimpleDateFormat
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
        initInstance()
    }

    private fun initInstance(){
        val options = RequestOptions().fitCenter()

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
        text_start_time.text = getLocalDateTime(matchInfo.startTimeStamp!!)
        text_score.text = "${matchInfo.homeScore} : ${matchInfo.awayScore}"
    }

    private fun getLocalDateTime(stringDate: String): String{
        val isoDateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        isoDateFormatter.timeZone = TimeZone.getTimeZone("UTC")
        val date = isoDateFormatter.parse(stringDate)
        val simpleDateFormatter = SimpleDateFormat("E dd MMM yyyy  HH:mm")
        return simpleDateFormatter.format(date)
    }
}