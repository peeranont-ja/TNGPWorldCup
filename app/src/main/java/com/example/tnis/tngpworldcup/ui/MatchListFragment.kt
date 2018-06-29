package com.example.tnis.tngpworldcup.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tnis.tngpworldcup.R
import com.example.tnis.tngpworldcup.adapter.MatchListAdapter
import com.example.tnis.tngpworldcup.datamanager.DataManager
import com.example.tnis.tngpworldcup.datamanager.model.Match
import com.example.tnis.tngpworldcup.datamanager.remote.model.MatchResponse
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_match_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MatchListFragment : Fragment() {

    //Declare DataManger parameter
    private val dataManager = DataManager()

    //Declare matchList for getting match response from API
    private lateinit var matchList: List<Match>

    //Static Method for Activity to call new instance
    companion object {
        fun newInstance(): MatchListFragment {
            return MatchListFragment()
        }
    }

    //Link XML to the fragment
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_match_list,
                container, false)
    }

    //Set up view actions when view is already created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInstance()
    }

    private fun initInstance() {
        /***        Use this code in Mock Case
        list_football_matches.layoutManager = LinearLayoutManager(activity)
        list_football_matches.adapter = MatchListAdapter(dataManager.getMockMatchInfo()) ***/

        //Show loading progress bar before getting data for API
        progress.visibility = View.VISIBLE

        //Call API getting match information through DataManager
        //Asynchronous Requests
        dataManager.getMatchInfo().enqueue(object : Callback<List<MatchResponse>> {
            override fun onResponse(call: Call<List<MatchResponse>>, response: Response<List<MatchResponse>>) {

                //when calling API successfully
                if (response.isSuccessful) {

                    //Log response data
                    Log.d("Response Body: ", response.body().toString())

                    //Map response object to our desired object
                    //In this case we map "MatchResponse" to "Match" object model
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

                    //After getting the data, hide the progress bar
                    progress.visibility = View.GONE

                    //Setup and add data to RecycleView Adapter
                    list_football_matches.layoutManager = LinearLayoutManager(activity)
                    list_football_matches.adapter = MatchListAdapter(matchList)
                }
                // Error response, no access to resource?
                else {
                    // Toast Error
                    Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()

                    // Don't forget to hide the progress bar
                    progress.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<List<MatchResponse>>, t: Throwable) {
                // Something went completely south (like no internet connection)

                // Toast the error message
                Toast.makeText(context, "Error message: ${t.message}", Toast.LENGTH_SHORT).show()

                // Don't forget to hide the progress bar
                progress.visibility = View.GONE
            }
        })
    }


}