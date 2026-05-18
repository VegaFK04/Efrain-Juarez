package com.example.efrainjuarez.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ClimaApi {
@GET
suspend fun getClima(
    @Query("apiid") apikey: String,
    @Query("q") ciudad: String,
    @Query("Unit") unidades: String
      )

}