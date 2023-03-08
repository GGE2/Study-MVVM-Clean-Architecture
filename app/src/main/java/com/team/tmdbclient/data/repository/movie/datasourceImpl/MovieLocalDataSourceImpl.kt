package com.team.tmdbclient.data.repository.movie.datasourceImpl

import com.team.tmdbclient.data.db.MovieDao
import com.team.tmdbclient.data.model.movie.Movie
import com.team.tmdbclient.data.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {

    // room에서 get 하는것은 room이 자동적으로 background에서 실행함
    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.getMovies()

    //room에서 get외의 것은 background에서 하라고 명시해야함
   override suspend fun saveMoviesToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}