package com.team.tmdbclient.data.api

import com.team.tmdbclient.data.model.artist.ArtistList
import com.team.tmdbclient.data.model.movie.MovieList
import com.team.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") api_key:String):Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") api_key:String) : Response<TvShowList>

    @GET("artist/popular")
    suspend fun getPopularArtists(@Query("api_key") api_key:String) : Response<ArtistList>



}