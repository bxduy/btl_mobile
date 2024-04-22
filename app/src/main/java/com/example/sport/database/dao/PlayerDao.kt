package com.example.sport.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.sport.model.Player

@Dao
interface PlayerDao {
    @Insert
    suspend fun insertPlayer(player: Player)

    @Delete
    suspend fun deletePlayer(player: Player)

    @Query("select * from player where teamId = :teamId")
    fun getPlayerById(teamId: Int): LiveData<List<Player>>
}