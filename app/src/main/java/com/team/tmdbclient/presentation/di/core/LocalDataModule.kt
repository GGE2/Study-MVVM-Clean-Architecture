package com.team.tmdbclient.presentation.di.core

import com.team.tmdbclient.data.db.ArtistDao
import com.team.tmdbclient.data.db.MovieDao
import com.team.tmdbclient.data.db.TvShowDao
import com.team.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.team.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import com.team.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.team.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.team.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.team.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao) : MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao) : TvShowLocalDataSource{
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao) : ArtistLocalDataSource{
        return ArtistLocalDatasourceImpl(artistDao)
    }

}