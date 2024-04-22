package com.example.sport.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "match", foreignKeys = [ForeignKey(
    entity = Team::class,
    parentColumns = ["id"],
    childColumns = ["teamId"],
    onDelete = ForeignKey.CASCADE
)])
class Match(@ColumnInfo(name = "competitor") var competitor: String = "",
            @ColumnInfo(name = "location") var location: String = "",
            @ColumnInfo(name = "date") var date: String = "",
            @ColumnInfo(name = "homeScore") var homeScore: Int = 0,
            @ColumnInfo(name = "awayScore") var awayScore: Int = 0,
            @ColumnInfo(name = "homePossession") var homePossession: Double = 0.0,
            @ColumnInfo(name = "awayPossession") var awayPossession: Double = 0.0,
            @ColumnInfo(name = "homeShot") var homeShot: Int = 0,
            @ColumnInfo(name = "awayShot") var awayShot: Int = 0,
            @ColumnInfo(name = "homeShotOnTarget") var homeShotOnTarget: Int = 0,
            @ColumnInfo(name = "awayShotOnTarget") var awayShotOnTarget: Int = 0,
            @ColumnInfo(name = "homePassing") var homePassing: Double = 0.0,
            @ColumnInfo(name = "awayPassing") var awayPassing: Double = 0.0,
            @ColumnInfo(name = "homeCorner") var homeCorner: Int = 0,
            @ColumnInfo(name = "awayCorner") var awayCorner: Int = 0,
            @ColumnInfo(name = "homeRedCard") var homeRedCard: Int = 0,
            @ColumnInfo(name = "awayRedCard") var awayRedCard: Int = 0,
            @ColumnInfo(name = "homeYellowCard") var homeYellowCard: Int = 0,
            @ColumnInfo(name = "awayYellowCard") var awayYellowCard: Int = 0,
            @ColumnInfo(name = "teamId") var teamId: Int ):java.io.Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int = 0
}