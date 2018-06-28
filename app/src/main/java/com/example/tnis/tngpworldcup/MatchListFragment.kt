package com.example.tnis.tngpworldcup

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MatchListFragment : Fragment() {
    var matchList  = arrayListOf<MatchItem>()
    companion object {
        fun newInstance(): MatchListFragment {
            return MatchListFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val rootView = inflater.inflate(R.layout.fragment_detail,
                container, false)
        initInstance(rootView)

        return rootView
    }

    private fun initInstance(rootView: View) {
        val rvMatchList = rootView.findViewById<RecyclerView>(R.id.rvMatchList)

        mockListData()
        rvMatchList.layoutManager = LinearLayoutManager(activity)
        rvMatchList.adapter = MatchListAdapter(matchList)
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