package com.team.tmdbclient.domain.usecase

import com.team.tmdbclient.data.model.artist.Artist
import com.team.tmdbclient.domain.repository.ArtistRepository

class GetArtistUseCase(private val artistRepository: ArtistRepository) {

    suspend fun excute():List<Artist>? = artistRepository.getArtist()

}