package com.team.tmdbclient.presentation.di.core

import com.team.tmdbclient.data.api.TMDBService
import com.team.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.team.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.team.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.team.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.team.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.team.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RemoteDataModule(
    private val apiKey : String
) {
    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService) : MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }


    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService) : ArtistRemoteDatasource{
        return ArtistRemoteDatasourceImpl(
            tmdbService,apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService) : TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(
            tmdbService,apiKey
        )
    }

}