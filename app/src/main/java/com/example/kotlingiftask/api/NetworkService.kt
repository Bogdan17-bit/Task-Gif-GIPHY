package com.example.kotlingiftask.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {

    private const val BASE_URL = "https://api.giphy.com/v1/gifs/"

    private fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }

    val apiService : ApiService by lazy {
        retrofit().create(ApiService::class.java)
    }

}