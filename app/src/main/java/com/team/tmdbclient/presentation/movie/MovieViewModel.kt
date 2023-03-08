package com.team.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.team.tmdbclient.domain.usecase.GetMoviesUseCase
import com.team.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase:GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData{
        val movieList = getMoviesUseCase.excute()
        emit(movieList)
    }
    fun updateMovies() = liveData{
        val movieList = updateMoviesUseCase.excute()
        emit(movieList)
    }

}