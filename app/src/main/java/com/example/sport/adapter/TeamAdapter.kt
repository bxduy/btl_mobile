package com.example.sport.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.sport.R
import com.example.sport.model.Team

class TeamAdapter(
    private val context: Context,
    private val onClick:(Team) -> Unit
):RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {
    private var teams: List<Team> = listOf()

    inner class TeamViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val txtTeam: TextView = itemView.findViewById(R.id.txt_team)
        private val layout_team: ConstraintLayout = itemView.findViewById(R.id.team_item)
        fun onBind(team: Team){
            txtTeam.text = team.name
            layout_team.setOnClickListener { onClick(team) }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.team_item, parent, false)
        return TeamViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.onBind(teams[position])
    }

    override fun getItemCount(): Int = teams.size

    fun setTeams(teams: List<Team>){
        this.teams = teams
        notifyDataSetChanged()
    }
}