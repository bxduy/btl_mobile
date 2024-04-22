package com.example.sport.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.sport.model.Match

@Dao
interface MatchDao {
    @Insert
    suspend fun insertMatch(match: Match)

    @Delete
    suspend fun deleteMatch(match: Match)

    @Query("select * from match where teamId = :teamId")
    fun getMatchById(teamId: Int): LiveData<List<Match>>
}