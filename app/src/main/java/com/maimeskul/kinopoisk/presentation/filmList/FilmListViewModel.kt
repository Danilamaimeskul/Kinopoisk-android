package com.maimeskul.kinopoisk.presentation.filmList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maimeskul.kinopoisk.common.Resource
import com.maimeskul.kinopoisk.domain.usecases.GetTopFilmsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FilmListViewModel @Inject constructor(
    private val getTopFilmsUseCase: GetTopFilmsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(FilmListState())
    val state: State<FilmListState> = _state

    init {
        getFilm()
    }

    private fun getFilm() {
        getTopFilmsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = FilmListState(films = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        FilmListState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = FilmListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}