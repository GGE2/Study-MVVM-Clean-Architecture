package com.team.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.team.tmdbclient.domain.usecase.GetArtistUseCase
import com.team.tmdbclient.domain.usecase.GetTvShowUseCase
import com.team.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.team.tmdbclient.domain.usecase.UpdateTvShowUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase,
    private val updateTvShowUseCase: UpdateTvShowUseCase
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }
}