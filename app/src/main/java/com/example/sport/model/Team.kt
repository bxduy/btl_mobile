package com.example.sport.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team")
class Team(@ColumnInfo(name = "name") var name: String = "",
           @ColumnInfo(name = "information") var information: String = "",
           @ColumnInfo(name = "country") var country: String = "",
           @ColumnInfo(name = "win") var win: Int = 0,
           @ColumnInfo(name = "draw") var draw: Int = 0,
           @ColumnInfo(name = "lose") var lose: Int = 0):java.io.Serializable{
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int = 0
}