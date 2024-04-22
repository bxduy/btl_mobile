package com.example.sport.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.sport.model.Team

@Dao
interface TeamDao {
    @Insert
    suspend fun insertTeam(team: Team)

    @Delete
    suspend fun deleteTeam(team: Team)

    @Query("select * from team")
    fun getAllTeam(): LiveData<List<Team>>
}