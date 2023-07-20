package com.maimeskul.kinopoisk.presentation.filmDetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maimeskul.kinopoisk.common.Constants
import com.maimeskul.kinopoisk.common.Resource
import com.maimeskul.kinopoisk.domain.usecases.GetFilmDetailsUseCase
import com.maimeskul.kinopoisk.presentation.filmList.FilmListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FilmDetailsViewModel @Inject constructor(
    private val getFilmDetailsUseCase: GetFilmDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(FilmDetailsState())
    val state: State<FilmDetailsState> = _state

    init {
        savedStateHandle.get<Int>(Constants.PARAM_FILM_ID)?.let { filmId ->
            getFilmDetails(filmId)
        }
    }

    private fun getFilmDetails(filmId: Int) {
        getFilmDetailsUseCase(
            filmId = filmId
        ).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = FilmDetailsState(filmDetails = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        FilmDetailsState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = FilmDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}