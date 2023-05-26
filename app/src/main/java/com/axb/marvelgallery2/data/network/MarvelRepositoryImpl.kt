package com.axb.marvelgallery2.data.network

import com.axb.marvelgallery2.data.network.provider.retrofit
import com.axb.marvelgallery2.model.MarvelCharacter
import io.reactivex.Single

class MarvelRepositoryImpl : MarvelRepository {

    val api = retrofit.create(MarvelApi::class.java)

    override fun getAllCharacters(searchQuery: String?): Single<List<MarvelCharacter>> =
        api.getCharacters(
            offset = 0,
            searchQuery = searchQuery,
            limit = elementsOnListLimit
        ).map {
            it.data?.results?.map(::MarvelCharacter) ?: emptyList() // 1
        }

    companion object {
        const val elementsOnListLimit = 50
    }
}
