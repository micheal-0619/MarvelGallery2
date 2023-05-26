package com.axb.marvelgallery2.data.network.dto

class CharacterMarvelDto {

    lateinit var name: String // 1
    lateinit var description: String
    lateinit var thumbnail: ImageDto // 1
    var comics: ListWrapper<ComicDto> = ListWrapper()
    var series: ListWrapper<ComicDto> = ListWrapper()
    var stories: ListWrapper<ComicDto> = ListWrapper()
    var events: ListWrapper<ComicDto> = ListWrapper()

    val imageUrl: String
        get() = thumbnail.completeImagePath
}