package com.team.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.team.tmdbclient.domain.usecase.GetArtistUseCase
import com.team.tmdbclient.domain.usecase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
): ViewModel(){

    fun getArtists() = liveData{
        val lists = getArtistUseCase.excute()
        emit(lists)
    }
    fun updateArtists() = liveData{
        val lists = updateArtistUseCase.excute()
        emit(lists)
    }


}