package com.example.tnis.tngpworldcup

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_match_list.*

class MatchListFragment : Fragment() {
    private var matchList = arrayListOf<MatchItem>()

    companion object {
        fun newInstance(): MatchListFragment {
            return MatchListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_match_list,
                container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInstance()
    }

    private fun initInstance() {
        mockListData()
        list_football_matches.layoutManager = LinearLayoutManager(activity)
        list_football_matches.adapter = MatchListAdapter(matchList)
    }

    private fun mockListData() {
        var match1 = MatchItem("1")
        match1.homeTeamUrl = "https://mblwc.cleverapps.io/images/RUS.png"
        match1.homeTeamName = "Russia"
        match1.awayTeamUrl = "https://mblwc.cleverapps.io/images/KSA.png"
        match1.awayTeamName = "Saudi Arabia"


        var match2 = MatchItem("2")
        match2.homeTeamUrl = "https://mblwc.cleverapps.io/images/EGY.png"
        match2.homeTeamName = "Egypt"
        match2.awayTeamUrl = "https://mblwc.cleverapps.io/images/URU.png"
        match2.awayTeamName = "Uruguay"

        matchList.add(match1)
        matchList.add(match2)
    }
}