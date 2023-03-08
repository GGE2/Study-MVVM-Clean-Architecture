package com.team.tmdbclient.data.repository.artist.datasource

import com.team.tmdbclient.data.model.artist.Artist
import com.team.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {

    suspend fun getArtist(): Response<ArtistList>
}