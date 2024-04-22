package com.example.sport.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sport.R
import com.example.sport.model.Match
import com.example.sport.model.Team

class MatchAdapter(
    private val context: Context,
    private val onClick:(Match) -> Unit
):RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {
    private var matchs: List<Match> = listOf()

    inner class MatchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val txtTeam2: TextView = itemView.findViewById(R.id.txt_team2)
        private val layout_match: ConstraintLayout = itemView.findViewById(R.id.layout_match)
        private val txtDate: TextView = itemView.findViewById(R.id.txt_date)
        private val txtLocation: TextView = itemView.findViewById(R.id.txt_location_match)
        fun onBind(match: Match){
            txtTeam2.text = match.competitor
            txtDate.text = match.date
            txtLocation.text = match.location
            layout_match.setOnClickListener { onClick(match) }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.match_item, parent, false)
        return MatchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.onBind(matchs[position])
    }

    override fun getItemCount(): Int = matchs.size

    fun setMatchs(matchs: List<Match>){
        this.matchs = matchs
        notifyDataSetChanged()
    }
}