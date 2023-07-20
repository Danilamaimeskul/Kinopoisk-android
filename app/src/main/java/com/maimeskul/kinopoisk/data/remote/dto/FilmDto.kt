package com.maimeskul.kinopoisk.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.maimeskul.kinopoisk.domain.model.Film


data class FilmDto(
    @SerializedName("countries")
    val countries: List<CountryDto?>?,
    @SerializedName("filmId")
    val filmId: Int?,
    @SerializedName("filmLength")
    val filmLength: String?,
    @SerializedName("genres")
    val genres: List<GenreDto?>?,
    @SerializedName("isAfisha")
    val isAfisha: Int?,
    @SerializedName("isRatingUp")
    val isRatingUp: Any?,
    @SerializedName("nameEn")
    val nameEn: String?,
    @SerializedName("nameRu")
    val nameRu: String?,
    @SerializedName("posterUrl")
    val posterUrl: String?,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String?,
    @SerializedName("rating")
    val rating: String?,
    @SerializedName("ratingChange")
    val ratingChange: Any?,
    @SerializedName("ratingVoteCount")
    val ratingVoteCount: Int?,
    @SerializedName("year")
    val year: String?
) {

}

fun FilmDto.toFilm(): Film {
    return Film(
        filmId = filmId,
        filmLength = filmLength,
        genres = genres?.map { genreDto -> genreDto?.toGenre() },
        nameEn = nameEn,
        nameRu = nameRu,
        posterUrlPreview = posterUrlPreview,
        rating = rating,
        ratingVoteCount = ratingVoteCount,
        year = year,
    )
}