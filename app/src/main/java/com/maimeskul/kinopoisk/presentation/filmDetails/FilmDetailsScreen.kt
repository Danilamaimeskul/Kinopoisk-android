package com.maimeskul.kinopoisk.presentation.filmDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.maimeskul.kinopoisk.presentation.filmList.FilmListViewModel

@Composable
fun FilmDetailsScreen(
    viewModel: FilmListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = "Hello, Compose!")
    }
}