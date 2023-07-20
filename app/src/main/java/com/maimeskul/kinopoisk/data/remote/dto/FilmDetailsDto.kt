package com.maimeskul.kinopoisk.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.maimeskul.kinopoisk.domain.model.FilmDetails


data class FilmDetailsDto(
    @SerializedName("completed")
    val completed: Boolean?,
    @SerializedName("countries")
    val countries: List<CountryDto?>?,
    @SerializedName("coverUrl")
    val coverUrl: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("editorAnnotation")
    val editorAnnotation: Any?,
    @SerializedName("endYear")
    val endYear: Any?,
    @SerializedName("filmLength")
    val filmLength: Int?,
    @SerializedName("genres")
    val genres: List<GenreDto?>?,
    @SerializedName("has3D")
    val has3D: Boolean?,
    @SerializedName("hasImax")
    val hasImax: Boolean?,
    @SerializedName("imdbId")
    val imdbId: String?,
    @SerializedName("isTicketsAvailable")
    val isTicketsAvailable: Boolean?,
    @SerializedName("kinopoiskHDId")
    val kinopoiskHDId: String?,
    @SerializedName("kinopoiskId")
    val kinopoiskId: Int?,
    @SerializedName("lastSync")
    val lastSync: String?,
    @SerializedName("logoUrl")
    val logoUrl: String?,
    @SerializedName("nameEn")
    val nameEn: Any?,
    @SerializedName("nameOriginal")
    val nameOriginal: String?,
    @SerializedName("nameRu")
    val nameRu: String?,
    @SerializedName("posterUrl")
    val posterUrl: String?,
    @SerializedName("posterUrlPreview")
    val posterUrlPreview: String?,
    @SerializedName("productionStatus")
    val productionStatus: Any?,
    @SerializedName("ratingAgeLimits")
    val ratingAgeLimits: String?,
    @SerializedName("ratingAwait")
    val ratingAwait: Any?,
    @SerializedName("ratingAwaitCount")
    val ratingAwaitCount: Int?,
    @SerializedName("ratingFilmCritics")
    val ratingFilmCritics: Double?,
    @SerializedName("ratingFilmCriticsVoteCount")
    val ratingFilmCriticsVoteCount: Int?,
    @SerializedName("ratingGoodReview")
    val ratingGoodReview: Double?,
    @SerializedName("ratingGoodReviewVoteCount")
    val ratingGoodReviewVoteCount: Int?,
    @SerializedName("ratingImdb")
    val ratingImdb: Double?,
    @SerializedName("ratingImdbVoteCount")
    val ratingImdbVoteCount: Int?,
    @SerializedName("ratingKinopoisk")
    val ratingKinopoisk: Double?,
    @SerializedName("ratingKinopoiskVoteCount")
    val ratingKinopoiskVoteCount: Int?,
    @SerializedName("ratingMpaa")
    val ratingMpaa: String?,
    @SerializedName("ratingRfCritics")
    val ratingRfCritics: Any?,
    @SerializedName("ratingRfCriticsVoteCount")
    val ratingRfCriticsVoteCount: Int?,
    @SerializedName("reviewsCount")
    val reviewsCount: Int?,
    @SerializedName("serial")
    val serial: Boolean?,
    @SerializedName("shortDescription")
    val shortDescription: String?,
    @SerializedName("shortFilm")
    val shortFilm: Boolean?,
    @SerializedName("slogan")
    val slogan: String?,
    @SerializedName("startYear")
    val startYear: Any?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("webUrl")
    val webUrl: String?,
    @SerializedName("year")
    val year: Int?
)

fun FilmDetailsDto.toFilmDetails(): FilmDetails {
    return FilmDetails(
        completed = completed,
        countries = countries?.map { countryDto -> countryDto?.toCountry() },
        coverUrl = coverUrl,
        description = description,
        editorAnnotation = editorAnnotation,
        year = year,
        posterUrlPreview = posterUrlPreview,
        posterUrl = posterUrl,
        nameRu = nameRu,
        filmLength = filmLength,
        nameEn = nameEn,
        genres = genres?.map { genreDto -> genreDto?.toGenre() },
        endYear = endYear,
        has3D = has3D,
        hasImax = hasImax,
        imdbId = imdbId,
        isTicketsAvailable = isTicketsAvailable,
        kinopoiskHDId = kinopoiskHDId,
        kinopoiskId = kinopoiskId,
        lastSync = lastSync,
        logoUrl = logoUrl,
        nameOriginal = nameOriginal,
        productionStatus = productionStatus,
        ratingAgeLimits = ratingAgeLimits,
        ratingAwait = ratingAwait,
        ratingFilmCritics = ratingFilmCritics,
        ratingAwaitCount = ratingAwaitCount,
        ratingFilmCriticsVoteCount = ratingFilmCriticsVoteCount,
        ratingGoodReview = ratingGoodReview,
        ratingGoodReviewVoteCount = ratingGoodReviewVoteCount,
        ratingImdb = ratingImdb,
        ratingImdbVoteCount = ratingImdbVoteCount,
        ratingKinopoisk = ratingKinopoisk,
        ratingKinopoiskVoteCount = ratingKinopoiskVoteCount,
        ratingMpaa = ratingMpaa,
        ratingRfCritics = ratingRfCritics,
        shortFilm = shortFilm,
        ratingRfCriticsVoteCount = ratingRfCriticsVoteCount,
        reviewsCount = reviewsCount,
        serial = serial,
        shortDescription = shortDescription,
        slogan = slogan,
        startYear = startYear,
        type = type,
        webUrl = webUrl
    )
}