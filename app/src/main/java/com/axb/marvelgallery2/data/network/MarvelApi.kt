package com.axb.marvelgallery2.data.network

import com.axb.marvelgallery2.data.network.dto.CharacterMarvelDto
import com.axb.marvelgallery2.data.network.dto.DataWrapper
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {

    @GET("characters")
    fun getCharacters(
            @Query("offset") offset: Int?,
            @Query("nameStartsWith") searchQuery: String?,
            @Query("limit") limit: Int?
    ): Single<DataWrapper<List<CharacterMarvelDto>>>
}
