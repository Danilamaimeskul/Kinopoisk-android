package com.maimeskul.kinopoisk.presentation.filmDetails

import com.maimeskul.kinopoisk.domain.model.FilmDetails

data class FilmDetailsState (
    val isLoading: Boolean = false,
    val filmDetails: FilmDetails? = null,
    val error: String = ""
)