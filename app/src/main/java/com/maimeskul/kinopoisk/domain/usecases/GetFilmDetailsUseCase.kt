package com.maimeskul.kinopoisk.domain.usecases

import com.maimeskul.kinopoisk.common.Resource
import com.maimeskul.kinopoisk.data.remote.dto.toFilmDetails
import com.maimeskul.kinopoisk.domain.model.FilmDetails
import com.maimeskul.kinopoisk.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetFilmDetailsUseCase @Inject constructor(
    private val repository: FilmRepository
){
    operator fun invoke(filmId: Int): Flow<Resource<FilmDetails>> = flow {
        try {
            emit(Resource.Loading<FilmDetails>())
            val film = repository.getFilmById(filmId).toFilmDetails()
            emit(Resource.Success<FilmDetails>(film))
        } catch(e: HttpException) {
            emit(Resource.Error<FilmDetails>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<FilmDetails>("Couldn't reach server. Check your internet connection."))
        }
    }
}