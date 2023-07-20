package com.maimeskul.kinopoisk.domain.model

data class Film(
    val filmId: Int?,
    val filmLength: String?,
    val genres: List<Genre?>?,
    val nameEn: String?,
    val nameRu: String?,
    val posterUrlPreview: String?,
    val rating: String?,
    val ratingVoteCount: Int?,
    val year: String?
)