package com.team.tmdbclient.presentation.di.artist

import com.team.tmdbclient.domain.usecase.GetArtistUseCase
import com.team.tmdbclient.domain.usecase.UpdateArtistUseCase
import com.team.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ):ArtistViewModelFactory{
        return ArtistViewModelFactory(getArtistUseCase, updateArtistUseCase)
    }


}