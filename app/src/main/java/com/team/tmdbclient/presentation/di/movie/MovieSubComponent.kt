package com.team.tmdbclient.presentation.di.movie

import com.team.tmdbclient.presentation.artist.ArtistActivity
import com.team.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent


@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
    
}