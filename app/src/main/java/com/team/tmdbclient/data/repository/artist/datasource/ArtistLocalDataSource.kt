package com.team.tmdbclient.data.repository.artist.datasource

import com.team.tmdbclient.data.model.artist.Artist
import com.team.tmdbclient.data.model.artist.ArtistList

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists:List<Artist>)
    suspend fun clearAll()
}