package com.axb.marvelgallery2.data.network

import com.axb.marvelgallery2.model.MarvelCharacter
import io.reactivex.Single

interface MarvelRepository {

    fun getAllCharacters(): Single<List<MarvelCharacter>>

    companion object : Provider<MarvelRepository>() {
        override fun creator() = MarvelRepositoryImpl()
    }
}
