package com.team.tmdbclient.data.repository.movie.datasource

import com.team.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}