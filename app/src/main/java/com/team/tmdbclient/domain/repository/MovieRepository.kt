package com.team.tmdbclient.domain.repository

import com.team.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies() : List<Movie>?
    suspend fun updateMovies() : List<Movie>?
}