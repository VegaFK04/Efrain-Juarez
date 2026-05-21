package com.example.efrainjuarez.api

import com.example.efrainjuarez.api.Modelos.ClimaModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ClimaApi {
@GET("/data/2.5/weather")
suspend fun getClima(
    @Query("apiid") apikey: String,
    @Query("q") ciudad: String,
    @Query("Unit") unidades: String
      ): Response<ClimaModel>

}