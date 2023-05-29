package com.axb.marvelgallery2.helpers


import com.axb.marvelgallery2.data.network.MarvelRepository
import com.axb.marvelgallery2.model.MarvelCharacter
import io.reactivex.Single

class BaseMarvelRepository(
        val onGetCharacters: () -> Single<List<MarvelCharacter>>
) : MarvelRepository {

    override fun getAllCharacters(searchQuery: String?): Single<List<MarvelCharacter>> = onGetCharacters()
}

