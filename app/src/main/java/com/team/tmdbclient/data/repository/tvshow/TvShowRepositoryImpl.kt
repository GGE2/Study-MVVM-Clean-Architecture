package com.team.tmdbclient.data.repository.tvshow

import android.util.Log
import com.team.tmdbclient.data.model.tvshow.TvShow
import com.team.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.team.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.team.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.team.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
) : TvShowRepository{
    override suspend fun getTvShow(): List<TvShow>? {
        return getTvShowsFromCache()
    }

    override suspend fun updateTvShow(): List<TvShow>? {

        val newListOfTvShows = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)

        return newListOfTvShows
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        var tvShowsList = emptyList<TvShow>()

        try{
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if(body!=null){
                tvShowsList = body.tvShows
            }
        }catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }

        return tvShowsList
    }
    suspend fun getTvShowsFromDB():List<TvShow>{
        var tvShowsList = emptyList<TvShow>()

        try{
            tvShowsList = tvShowLocalDataSource.getTvShowsFromDB()
        }catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }
        if(tvShowsList.isNotEmpty()){
            return tvShowsList
        }else{
            tvShowsList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowsList)
        }
        return tvShowsList
    }
    suspend fun getTvShowsFromCache() : List<TvShow>{
        var tvShowsList = emptyList<TvShow>()

        try{
            tvShowsList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch(e:Exception){
            Log.i("MyTag", e.message.toString())
        }
        if(tvShowsList.isNotEmpty()){
            return tvShowsList
        }else{
            tvShowsList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowsList)
        }
        return tvShowsList
    }
}