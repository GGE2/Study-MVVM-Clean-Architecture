package com.team.tmdbclient.presentation.di.core

import com.team.tmdbclient.domain.repository.ArtistRepository
import com.team.tmdbclient.domain.repository.MovieRepository
import com.team.tmdbclient.domain.repository.TvShowRepository
import com.team.tmdbclient.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository) : GetMoviesUseCase{
        return GetMoviesUseCase(movieRepository)
    }


    @Singleton
    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository) : UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Singleton
    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository) : GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }


    @Singleton
    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository) : UpdateTvShowUseCase{
        return UpdateTvShowUseCase(tvShowRepository)
    }


    @Singleton
    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository) : GetArtistUseCase{
        return GetArtistUseCase(artistRepository)
    }


    @Singleton
    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository) : UpdateArtistUseCase{
        return UpdateArtistUseCase(artistRepository)
    }


}