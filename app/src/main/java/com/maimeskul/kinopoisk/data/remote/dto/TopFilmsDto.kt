package com.maimeskul.kinopoisk.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TopFilmsDto(
    @SerializedName("films")
    val films: List<FilmDto>,
    @SerializedName("pagesCount")
    val pagesCount: Int?
)