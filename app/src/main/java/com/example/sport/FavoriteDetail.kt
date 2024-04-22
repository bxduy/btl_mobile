package com.example.sport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sport.model.Team
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_favorite_detail.*

class FavoriteDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_detail)
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        val team = intent.getSerializableExtra("team") as Team
        favor.setText(team.name)
        adapter.setTeam(team)
        pager.adapter = adapter
        TabLayoutMediator(tab, pager){tab, pos ->
            when(pos){
                0->{tab.text = "Information"}
                1->{tab.text = "Match"}
                2->{tab.text = "Achievement"}
                else->{tab.text = "Player"}
            }
        }.attach()
    }
}