package com.example.sport

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sport.model.Team

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle):FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    private var team: Team? = null

    fun setTeam(team: Team) {
        this.team = team
        notifyDataSetChanged() // Cập nhật ViewPager khi có dữ liệu mới
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{InforFragment.newInstance(team!!)}
            1->{MatchFragment.newInstance(team!!)}
            2->{TableFragment.newInstance(team!!)}
            else -> {PlayerFragment()}
        }
    }
}