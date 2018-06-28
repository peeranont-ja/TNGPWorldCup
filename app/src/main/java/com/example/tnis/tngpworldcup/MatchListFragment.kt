package com.example.tnis.tngpworldcup

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tnis.tngpworldcup.Adapter.MatchListAdapter
import com.example.tnis.tngpworldcup.DataManager.DataManager
import kotlinx.android.synthetic.main.fragment_match_list.*

class MatchListFragment : Fragment() {
    private val dataManager = DataManager()

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
        list_football_matches.layoutManager = LinearLayoutManager(activity)
        list_football_matches.adapter = MatchListAdapter(dataManager.getMockMatchInfo())

//        dataManager.getMatchInfo().enqueue(object : Callback<List<Match>> {
//            override fun onResponse(call: Call<List<Match>>, response: Response<List<Match>>) {
//                Log.d("Response Body: ", response.body().toString())
//
//                list_football_matches.layoutManager = LinearLayoutManager(activity)
//                list_football_matches.adapter = MatchListAdapter(response.body()!!)
//            }
//
//            override fun onFailure(call: Call<List<Match>>, t: Throwable) {
//                Toast.makeText(context, "Error message: "
//                        + t.message, Toast.LENGTH_SHORT).show()
//            }
//        })
    }


}