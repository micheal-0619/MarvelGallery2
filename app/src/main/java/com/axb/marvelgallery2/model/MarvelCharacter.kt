package com.axb.marvelgallery2.model

import com.axb.marvelgallery2.data.network.dto.CharacterMarvelDto

data class MarvelCharacter(
    val name: String,
    val imageUrl: String
) {
    constructor(dto: CharacterMarvelDto) : this(
        name = dto.name,
        imageUrl = dto.imageUrl
    )
}
