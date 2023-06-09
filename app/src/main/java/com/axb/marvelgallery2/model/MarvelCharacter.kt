package com.axb.marvelgallery2.model

import android.os.Parcel
import android.os.Parcelable
import com.axb.marvelgallery2.data.network.dto.CharacterMarvelDto

data class MarvelCharacter(
    val name: String?,
    val imageUrl: String?,
    val description: String? = "",
    val comics: List<String> = listOf(),
    val series: List<String> = listOf(),
    val stories: List<String> = listOf(),
    val events: List<String> = listOf()
) : Parcelable {

    constructor(dto: CharacterMarvelDto) : this(
        name = dto.name,
        imageUrl = dto.imageUrl,
        description = dto.description,
        comics = dto.comics.items.map { it.name },
        series = dto.series.items.map { it.name },
        stories = dto.stories.items.map { it.name },
        events = dto.events.items.map { it.name }
    )

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.createStringArrayList()!!,
        source.createStringArrayList()!!,
        source.createStringArrayList()!!,
        source.createStringArrayList()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        with(dest) {
            writeString(name)
            writeString(imageUrl)
            writeString(description)
            writeStringList(comics)
            writeStringList(series)
            writeStringList(stories)
            writeStringList(events)
        }
    }

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<MarvelCharacter> = object : Parcelable.Creator<MarvelCharacter> {
            override fun createFromParcel(source: Parcel): MarvelCharacter = MarvelCharacter(source)
            override fun newArray(size: Int): Array<MarvelCharacter?> = arrayOfNulls(size)
        }
    }
}
