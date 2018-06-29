package com.example.tnis.tngpworldcup.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tnis.tngpworldcup.datamanager.DataManager
import com.example.tnis.tngpworldcup.datamanager.model.Match
import com.example.tnis.tngpworldcup.ui.DetailActivity
import com.example.tnis.tngpworldcup.R
import kotlinx.android.synthetic.main.item_match.view.*

class MatchListAdapter(private var matchList: List<Match>) : RecyclerView.Adapter<MatchListHolder>() {

    private var dataManager = DataManager()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MatchListHolder(view)
    }

    override fun onBindViewHolder(holder: MatchListHolder, position: Int) {
        val countryHome = matchList[position].homeTeamName
        val countryAway = matchList[position].awayTeamName

        val countryHomeUrl =
                dataManager.getFlagURL(matchList[position].homeTeamShortName!!)
        val countryAwayUrl =
                dataManager.getFlagURL(matchList[position].awayTeamShortName!!)

        holder.itemView.text_match_number.text = "Match ${position + 1}"
        holder.itemView.text_home_team_name.text = countryHome
        holder.itemView.text_away_team_name.text = countryAway

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("matchInfo", matchList[position])
            holder.itemView.context.startActivity(intent)
        }

        val option = RequestOptions().centerCrop()
        Glide.with(holder.itemView.context)
                .load(countryHomeUrl)
                .apply(option)
                .into(holder.itemView.image_flag_home_team)
        Glide.with(holder.itemView.context)
                .load(countryAwayUrl)
                .apply(option)
                .into(holder.itemView.image_flag_away_team)
    }

    override fun getItemCount(): Int {
        return matchList.size
    }
}

class MatchListHolder(itemView: View) : RecyclerView.ViewHolder(itemView)