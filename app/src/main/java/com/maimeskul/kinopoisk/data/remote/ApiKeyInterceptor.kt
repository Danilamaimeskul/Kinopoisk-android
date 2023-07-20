package com.maimeskul.kinopoisk.data.remote

import com.maimeskul.kinopoisk.common.Constants
import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
            .header("X-API-KEY", Constants.API_KEY)

        val modifiedRequest = requestBuilder.build()
        return chain.proceed(modifiedRequest)
    }
}