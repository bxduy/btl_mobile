package com.example.sport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.sport.adapter.TeamAdapter
import com.example.sport.model.Match
import com.example.sport.model.Team
import com.example.sport.viewmodel.FavoriteViewModel
import kotlinx.android.synthetic.main.activity_favorite.*

class Favorite : AppCompatActivity() {
    private val favoriteViewModel: FavoriteViewModel by lazy {
        ViewModelProvider(this, FavoriteViewModel
            .FavoriteViewModelFactory(this.application)
        )[FavoriteViewModel::class.java]
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite)
        val match = Match("Man City", "Etihad", "2024/03/18"
        , 3, 2, 80.0, 20.0, 5, 6
        , 4, 2, 55.0, 45.0, 3, 2
        , 0, 0, 1, 1, 1)
        favoriteViewModel.insertMatch(match)
//        val team = Team("Arsenal", "The Arsenal Football Club, commonly known as Arsenal" +
//                ", is an English professional football club based in Holloway" +
//                ", North London. Arsenal compete in the Premier League" +
//                ", the top flight of English football. In domestic football" +
//                ", Arsenal has won 13 league titles (including one unbeaten title)" +
//                ", a record 14 FA Cups, two League Cups" +
//                ", 17 FA Community Shields and a Football League Centenary Trophy. In European football" +
//                ", they have one European Cup Winners' Cup and one Inter-Cities Fairs Cup" +
//                ". In terms of trophies won, it is the third-most successful club in English football."
//                , "England", 20, 8, 9)
//        favoriteViewModel.insertTeam(team)
        initControl()
    }
    private fun initControl() {
        val adapter: TeamAdapter = TeamAdapter(this@Favorite, onClickItem )
        rv_fr.setHasFixedSize(true)
        rv_fr.layoutManager = LinearLayoutManager(this)
        rv_fr.adapter = adapter
        favoriteViewModel.getAllTeam().observe(this, Observer {
            adapter.setTeams(it)
        })
    }

    private val onClickItem:(Team) -> Unit = {
        val intent = Intent(this, FavoriteDetail::class.java)
        intent.putExtra("team", it)
        startActivity(intent)
    }
}