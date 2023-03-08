package com.team.tmdbclient.presentation.di

import com.team.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.team.tmdbclient.presentation.di.movie.MovieSubComponent
import com.team.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent():MovieSubComponent
    fun createTvShowSubComponent():TvShowSubComponent
    fun createArtistSubComponent():ArtistSubComponent



}