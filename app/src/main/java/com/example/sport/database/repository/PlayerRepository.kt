package com.example.sport.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.sport.database.SportDatabase
import com.example.sport.database.dao.MatchDao
import com.example.sport.database.dao.PlayerDao
import com.example.sport.model.Match
import com.example.sport.model.Player

class PlayerRepository(app: Application) {
    private val playerDao: PlayerDao
    init {
        val playerDatabase = SportDatabase.getInstance(app)
        playerDao = playerDatabase.playerDao()
    }
    suspend fun insertPlayer(player: Player) = playerDao.insertPlayer(player)
    suspend fun deletePlayer(player: Player) = playerDao.deletePlayer(player)
    fun getPlayerById(teamId: Int): LiveData<List<Player>> = playerDao.getPlayerById(teamId)
}