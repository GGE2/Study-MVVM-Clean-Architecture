package com.team.tmdbclient.data.repository.artist

import android.util.Log
import com.team.tmdbclient.data.model.artist.Artist
import com.team.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.team.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.team.tmdbclient.data.repository.artist.datasource.ArtistRemoteDatasource
import com.team.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.team.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository{
    override suspend fun getArtist(): List<Artist>? {
        return getArtistFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
        val newListOfArtists = getArtistFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistFromAPI() : List<Artist>{
        var artistList = emptyList<Artist>()
        try{
            val response = artistRemoteDatasource.getArtist()
            val body = response.body()
            if(body!=null){
                artistList = body.artists
            }
        }catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }
        return artistList
    }
    suspend fun getArtistFromDB() : List<Artist>{
        var artistList = emptyList<Artist>()
        try{
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }
        if(artistList.size>0){
            return artistList
        }else{
            artistList = getArtistFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }
    suspend fun getArtistFromCache() : List<Artist>{
        var artistList = emptyList<Artist>()
        try{
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }
        if(artistList.isNotEmpty()){
            return artistList
        }else{
            artistList = getArtistFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}