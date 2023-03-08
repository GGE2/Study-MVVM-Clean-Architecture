package com.team.tmdbclient.data.repository.artist.datasourceImpl

import com.team.tmdbclient.data.api.TMDBService
import com.team.tmdbclient.data.db.ArtistDao
import com.team.tmdbclient.data.model.artist.ArtistList
import com.team.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey : String
) : ArtistRemoteDatasource{
    override suspend fun getArtist():Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}