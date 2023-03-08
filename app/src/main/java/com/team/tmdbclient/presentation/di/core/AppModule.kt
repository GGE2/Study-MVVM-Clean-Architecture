package com.team.tmdbclient.presentation.di.core

import android.content.Context
import com.team.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.team.tmdbclient.presentation.di.movie.MovieSubComponent
import com.team.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,TvShowSubComponent::class,ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provieApplicationContext() : Context {
        return context.applicationContext
    }

}