package com.example.sport.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.sport.database.SportDatabase
import com.example.sport.database.dao.TeamDao
import com.example.sport.model.Team

class TeamRepository(app: Application) {
    private val teamDao: TeamDao
    init {
        val teamDatabase: SportDatabase = SportDatabase.getInstance(app)
        teamDao = teamDatabase.teamDao()
    }

    suspend fun insertTeam(team: Team) = teamDao.insertTeam(team)
    suspend fun deleteTeam(team: Team) = teamDao.deleteTeam(team)
    fun getAllTeam(): LiveData<List<Team>> = teamDao.getAllTeam()
}