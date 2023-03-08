package com.team.tmdbclient.domain.repository

import com.team.tmdbclient.data.model.tvshow.TvShow


interface TvShowRepository {

    suspend fun getTvShow():List<TvShow>?
    suspend fun updateTvShow():List<TvShow>?
}