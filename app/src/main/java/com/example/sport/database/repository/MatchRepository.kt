package com.example.sport.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.sport.database.SportDatabase
import com.example.sport.database.dao.MatchDao
import com.example.sport.model.Match


class MatchRepository(app: Application) {
    private val matchDao: MatchDao
    init {
        val matchDatabase = SportDatabase.getInstance(app)
        matchDao = matchDatabase.matchDao()
    }
    suspend fun insertMatch(match: Match) = matchDao.insertMatch(match)
    suspend fun deleteMatch(match: Match) = matchDao.deleteMatch(match)
    fun getMatchById(teamId: Int): LiveData<List<Match>> = matchDao.getMatchById(teamId)
}