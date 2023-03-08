package com.team.tmdbclient.presentation.di.core

import com.team.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.team.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.team.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.team.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.team.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.team.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.team.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import com.team.tmdbclient.data.repository.movie.datasource.MovieRemoteDataSource
import com.team.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.team.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.team.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.team.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.team.tmdbclient.domain.repository.ArtistRepository
import com.team.tmdbclient.domain.repository.MovieRepository
import com.team.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ) : MovieRepository{
        return MovieRepositoryImpl(movieRemoteDataSource, movieLocalDataSource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ) : TvShowRepository{
        return TvShowRepositoryImpl(tvShowRemoteDataSource, tvShowLocalDataSource, tvShowCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDatasource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ) : ArtistRepository{
        return ArtistRepositoryImpl(artistRemoteDatasource, artistLocalDataSource, artistCacheDataSource)
    }


}