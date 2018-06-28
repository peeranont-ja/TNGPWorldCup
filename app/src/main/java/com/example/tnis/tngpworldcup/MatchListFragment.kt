package com.example.tnis.tngpworldcup

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tnis.tngpworldcup.adapter.MatchListAdapter
import com.example.tnis.tngpworldcup.datamanager.DataManager
import com.example.tnis.tngpworldcup.datamanager.model.Match
import com.example.tnis.tngpworldcup.datamanager.remote.model.MatchResponse
import kotlinx.android.synthetic.main.fragment_match_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchListFragment : Fragment() {
    private val dataManager = DataManager()
    private lateinit var matchList: List<Match>

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
//        Use this code in Mock Case
//        list_football_matches.layoutManager = LinearLayoutManager(activity)
//        list_football_matches.adapter = MatchListAdapter(dataManager.getMockMatchInfo())

        dataManager.getMatchInfo().enqueue(object : Callback<List<MatchResponse>> {
            override fun onResponse(call: Call<List<MatchResponse>>, response: Response<List<MatchResponse>>) {
                Log.d("Response Body: ", response.body().toString())

                matchList = response.body()!!.map {
                    Match(
                            it.matchNo,
                            it.matchType,
                            it.startTimeStamp,
                            it.homeTeamShortName,
                            it.awayTeamShortName,
                            it.homeTeamName,
                            it.awayTeamName,
                            it.homeScore,
                            it.awayScore
                    )
                }

                list_football_matches.layoutManager = LinearLayoutManager(activity)
                list_football_matches.adapter = MatchListAdapter(matchList)
            }

            override fun onFailure(call: Call<List<MatchResponse>>, t: Throwable) {
                Toast.makeText(context, "Error message: "
                        + t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }


}