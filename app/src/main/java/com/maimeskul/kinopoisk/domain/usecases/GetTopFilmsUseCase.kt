package com.maimeskul.kinopoisk.domain.usecases

import com.maimeskul.kinopoisk.common.Resource
import com.maimeskul.kinopoisk.data.remote.dto.toFilm
import com.maimeskul.kinopoisk.domain.model.Film
import com.maimeskul.kinopoisk.domain.repository.FilmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTopFilmsUseCase @Inject constructor(
    private val repository: FilmRepository
) {
    operator fun invoke(): Flow<Resource<List<Film>>> = flow {
        try {
            emit(Resource.Loading<List<Film>>())
            val films = repository.getTopFilms().films.map { filmDto -> filmDto.toFilm() }
            emit(Resource.Success<List<Film>>(films))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Film>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Film>>("Couldn't reach server. Check your internet connection."))
        }
    }
}