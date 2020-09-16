package com.lgcinterview.letsgetcountries.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitSource {

    companion object {
        const val BASE_URL = "https://restcountries-v1.p.rapidapi.com/"
    }

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .build()
    }

    val retrofitRequests : RetrofitRequests by lazy {
        retrofit.create(RetrofitRequests::class.java)
    }
}