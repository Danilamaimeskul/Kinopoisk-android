package com.maimeskul.kinopoisk.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.maimeskul.kinopoisk.domain.model.Country

data class CountryDto(
    @SerializedName("country")
    val country: String?
)

fun CountryDto.toCountry(): Country {
    return Country(
        country = country
    )
}