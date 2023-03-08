package com.team.tmdbclient.data.repository.movie.datasourceImpl

import com.team.tmdbclient.data.model.movie.Movie
import com.team.tmdbclient.data.model.tvshow.TvShow
import com.team.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.team.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}