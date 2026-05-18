package com.example.efrainjuarez.api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstanciaRetroFit {
    private val BURL="https://api.openweathermap.org"

    private fun getInstance(): Retrofit{
        return Retrofit.Builder().baseUrl(BURL).
        addConverterFactory(GsonConverterFactory.
        create()).build()
    }
    val climaApi=getInstance().create(ClimaApi::class.java)
}