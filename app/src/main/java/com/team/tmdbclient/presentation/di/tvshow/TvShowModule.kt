package com.team.tmdbclient.presentation.di.tvshow

import com.team.tmdbclient.domain.usecase.GetMoviesUseCase
import com.team.tmdbclient.domain.usecase.GetTvShowUseCase
import com.team.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.team.tmdbclient.domain.usecase.UpdateTvShowUseCase
import com.team.tmdbclient.presentation.movie.MovieViewModelFactory
import com.team.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ):TvShowViewModelFactory{
        return TvShowViewModelFactory(getTvShowUseCase, updateTvShowUseCase)
    }


}