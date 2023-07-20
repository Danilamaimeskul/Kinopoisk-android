package com.maimeskul.kinopoisk.data.repository

import com.maimeskul.kinopoisk.data.remote.KinopoiskAPI
import com.maimeskul.kinopoisk.data.remote.dto.FilmDetailsDto
import com.maimeskul.kinopoisk.data.remote.dto.TopFilmsDto
import com.maimeskul.kinopoisk.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val api: KinopoiskAPI
) : FilmRepository {

    override suspend fun getTopFilms(): TopFilmsDto {
        return api.getTopFilms()
    }

    override suspend fun getFilmById(filmId: Int): FilmDetailsDto {
        return api.getFilmById(filmId)
    }
}