package com.example.tnis.tngpworldcup

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.match_item.view.*

class MatchListAdapter(matchList: ArrayList<MatchItem>) : RecyclerView.Adapter<MatchListHolder>() {
var matches = matchList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.match_item, parent, false)
        return MatchListHolder(view)
    }

    override fun onBindViewHolder(holder: MatchListHolder, position: Int) {
        val countryHome = matches.get(position).homeTeamName
        val countryAway = matches.get(position).awayTeamName

        val countryHomeUrl = matches.get(position).homeTeamUrl
        val countryAwayUrl = matches.get(position).awayTeamUrl

        holder?.itemView.tvMatch.text = "Match " + (position + 1).toString();
        holder?.itemView.tvCountryHome.text = countryHome
        holder?.itemView.tvCountryAway.text = countryAway

        var option =RequestOptions().centerCrop()
        Glide.with(holder.itemView.context)
                .load(countryHomeUrl)
                .apply(option)
                .into(holder.itemView.imvFlagHome)
        Glide.with(holder.itemView.context)
                .load(countryAwayUrl)
                .apply(option)
                .into(holder.itemView.imvFlagAway)
    }

    override fun getItemCount(): Int {
        return matches.size
    }


}

class MatchListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
}