package com.lgcinterview.letsgetcountries.data.retrofit

import com.lgcinterview.letsgetcountries.data.models.Country
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitRequests {

    @Headers(
        "x-rapidapi-host:restcountries-v1.p.rapidapi.com",
        "x-rapidapi-key:1299a33cf5msh3118bae71f8946fp11fe2djsn6acf1bb5690c")
    @GET("all/")
    suspend fun getAllCountries() : List<Country>
}