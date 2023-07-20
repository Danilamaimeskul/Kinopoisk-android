package com.maimeskul.kinopoisk.presentation.filmList

import com.maimeskul.kinopoisk.domain.model.Film

data class FilmListState (
    val isLoading: Boolean = false,
    val films: List<Film> = emptyList(),
    val error: String = ""
    )