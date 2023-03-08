package com.team.tmdbclient.presentation.di.movie

import com.team.tmdbclient.domain.usecase.GetArtistUseCase
import com.team.tmdbclient.domain.usecase.GetMoviesUseCase
import com.team.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.team.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.team.tmdbclient.presentation.artist.ArtistViewModelFactory
import com.team.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ):MovieViewModelFactory{
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }


}