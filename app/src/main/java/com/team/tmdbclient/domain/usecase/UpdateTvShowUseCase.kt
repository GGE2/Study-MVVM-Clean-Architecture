package com.team.tmdbclient.domain.usecase

import com.team.tmdbclient.data.model.tvshow.TvShow
import com.team.tmdbclient.domain.repository.TvShowRepository

class UpdateTvShowUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun excute():List<TvShow>? = tvShowRepository.updateTvShow()
}