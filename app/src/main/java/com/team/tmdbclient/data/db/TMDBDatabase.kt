package com.team.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.team.tmdbclient.data.model.artist.Artist
import com.team.tmdbclient.data.model.movie.Movie
import com.team.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class,Artist::class,TvShow::class], version = 1,
exportSchema = false)
abstract class TMDBDatabase : RoomDatabase(){

    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistsDao(): ArtistDao
}