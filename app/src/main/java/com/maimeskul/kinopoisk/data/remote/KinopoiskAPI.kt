package com.maimeskul.kinopoisk.data.remote

import com.maimeskul.kinopoisk.data.remote.dto.FilmDetailsDto
import com.maimeskul.kinopoisk.data.remote.dto.TopFilmsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface KinopoiskAPI {

    @GET("/api/v2.2/films/top")
    suspend fun getTopFilms(): TopFilmsDto

    @GET("/api/v2.2/films/{filmId}")
    suspend fun getFilmById(@Path("filmId") filmId: Int): FilmDetailsDto
}