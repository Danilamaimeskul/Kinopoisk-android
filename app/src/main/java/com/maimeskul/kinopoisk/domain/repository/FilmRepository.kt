package com.maimeskul.kinopoisk.domain.repository

import com.maimeskul.kinopoisk.data.remote.dto.FilmDetailsDto
import com.maimeskul.kinopoisk.data.remote.dto.TopFilmsDto

interface FilmRepository {

    suspend fun getTopFilms(): TopFilmsDto

    suspend fun getFilmById(filmId: Int): FilmDetailsDto
}