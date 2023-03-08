package com.team.tmdbclient.domain.repository

import com.team.tmdbclient.data.model.artist.Artist

interface ArtistRepository {

    suspend fun getArtist():List<Artist>?
    suspend fun updateArtist():List<Artist>?

}