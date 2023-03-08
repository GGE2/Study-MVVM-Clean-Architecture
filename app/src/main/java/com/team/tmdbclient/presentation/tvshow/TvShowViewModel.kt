package com.team.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.team.tmdbclient.domain.usecase.GetArtistUseCase
import com.team.tmdbclient.domain.usecase.GetTvShowUseCase
import com.team.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.team.tmdbclient.domain.usecase.UpdateTvShowUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
): ViewModel(){

    fun getArtists() = liveData{
        val lists = getTvShowUseCase.excute()
        emit(lists)
    }
    fun updateArtists() = liveData{
        val lists = updateTvShowUseCase.excute()
        emit(lists)
    }


}