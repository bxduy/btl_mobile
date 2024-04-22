package com.example.sport.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sport.database.dao.MatchDao
import com.example.sport.database.dao.PlayerDao
import com.example.sport.database.dao.TeamDao
import com.example.sport.model.Match
import com.example.sport.model.Player
import com.example.sport.model.Team

@Database(entities = [Team::class, Player::class, Match::class], version = 2)
abstract class SportDatabase: RoomDatabase(){
    abstract fun teamDao(): TeamDao
    abstract fun playerDao(): PlayerDao
    abstract fun matchDao(): MatchDao
    companion object{
        @Volatile
        private var instance : SportDatabase ?= null

        fun getInstance(context: Context): SportDatabase {
            if(instance == null){
                instance = Room.databaseBuilder(context
                    , SportDatabase::class.java, "SportDatabase").fallbackToDestructiveMigration().build()
            }
            return instance!!
        }
    }
}