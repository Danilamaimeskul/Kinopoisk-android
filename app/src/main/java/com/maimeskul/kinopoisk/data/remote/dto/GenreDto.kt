package com.maimeskul.kinopoisk.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.maimeskul.kinopoisk.domain.model.Genre

data class GenreDto(
    @SerializedName("genre")
    val genre: String?
)
fun GenreDto.toGenre(): Genre {
    return Genre(
        genre = genre
    )
}