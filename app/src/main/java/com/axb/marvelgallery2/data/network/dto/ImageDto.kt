package com.axb.marvelgallery2.data.network.dto

class ImageDto {

    lateinit var path: String // 1
    lateinit var extension: String // 1

    val completeImagePath: String
        get() = "$path.$extension"
}
