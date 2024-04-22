package com.example.sport.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "player", foreignKeys = [ForeignKey(
    entity = Team::class,
    parentColumns = ["id"],
    childColumns = ["teamId"],
    onDelete = ForeignKey.CASCADE
)])
class Player(@ColumnInfo(name = "name") var name: String = "",
             @ColumnInfo(name = "country") var country: String = "",
             @ColumnInfo(name = "age") var age: Int = 0,
             @ColumnInfo(name = "position") var position: String = "",
             @ColumnInfo(name = "jerseyNumber") var jerseyNumber: String = "",
             @ColumnInfo(name = "goal") var goal: Int = 0,
             @ColumnInfo(name = "assist") var assist: Int = 0,
             @ColumnInfo(name = "teamId") var teamId: Int):java.io.Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int = 0
}