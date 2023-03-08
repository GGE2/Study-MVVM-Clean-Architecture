package com.team.tmdbclient.domain.usecase

import com.team.tmdbclient.data.model.movie.Movie
import com.team.tmdbclient.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun excute() : List<Movie>? = movieRepository.getMovies()


}