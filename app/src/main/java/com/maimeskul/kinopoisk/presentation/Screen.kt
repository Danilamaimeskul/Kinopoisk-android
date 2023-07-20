package com.maimeskul.kinopoisk.presentation

sealed class Screen(val route: String) {
    object FilmListScreen: Screen("filmListScreen")
    object FilmDetailsScreen: Screen("filmDetailsScreen")
}