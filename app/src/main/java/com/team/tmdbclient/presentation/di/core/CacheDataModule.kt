package com.team.tmdbclient.presentation.di.core

import com.team.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.team.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.team.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.team.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.team.tmdbclient.data.repository.movie.datasourceImpl.TvShowCacheDataSourceImpl
import com.team.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import dagger.Module

import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource  = MovieCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource  = ArtistCacheDataSourceImpl()

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCacheDataSource  = TvShowCacheDataSourceImpl()
}