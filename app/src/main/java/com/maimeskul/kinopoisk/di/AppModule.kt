package com.maimeskul.kinopoisk.di

import com.maimeskul.kinopoisk.common.Constants
import com.maimeskul.kinopoisk.data.remote.ApiKeyInterceptor
import com.maimeskul.kinopoisk.data.remote.KinopoiskAPI
import com.maimeskul.kinopoisk.data.repository.FilmRepositoryImpl
import com.maimeskul.kinopoisk.domain.repository.FilmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideKinopoiskApi(): KinopoiskAPI {

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(ApiKeyInterceptor())

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
            .create(KinopoiskAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideFilmRepository(api: KinopoiskAPI): FilmRepository {
        return FilmRepositoryImpl(api)
    }
}