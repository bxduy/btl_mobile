package com.example.sport.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.sport.database.repository.MatchRepository
import com.example.sport.database.repository.PlayerRepository
import com.example.sport.database.repository.TeamRepository
import com.example.sport.model.Match
import com.example.sport.model.Player
import com.example.sport.model.Team
import kotlinx.coroutines.launch

class FavoriteViewModel(app: Application): ViewModel() {
    private val teamRepository: TeamRepository = TeamRepository(app)
    private val matchRepository: MatchRepository = MatchRepository(app)
    private val playerRepository: PlayerRepository = PlayerRepository(app)
    // Team
    fun insertTeam(team: Team) = viewModelScope.launch {
        teamRepository.insertTeam(team)
    }

    fun deleteTeam(team: Team) = viewModelScope.launch {
        teamRepository.deleteTeam(team)
    }

    fun getAllTeam(): LiveData<List<Team>> = teamRepository.getAllTeam()

    // Match

    fun insertMatch(match: Match) = viewModelScope.launch {
        matchRepository.insertMatch(match)
    }

    fun deleteMatch(match: Match) = viewModelScope.launch {
        matchRepository.deleteMatch(match)
    }

    fun getMatchById(teamId: Int): LiveData<List<Match>> = matchRepository.getMatchById(teamId)

    // Player
    fun insertPlayer(player: Player) = viewModelScope.launch {
        playerRepository.insertPlayer(player)
    }

    fun deletePlayer(player: Player) = viewModelScope.launch {
        playerRepository.deletePlayer(player)
    }

    fun getPlayerById(teamId: Int): LiveData<List<Player>> = playerRepository.getPlayerById(teamId)

    class FavoriteViewModelFactory(private val application: Application): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return FavoriteViewModel(application) as T
            }
            throw IllegalArgumentException("Unable construct viewModel")
        }
    }

}