package com.example.kotlingiftask.api

import com.example.kotlingiftask.model.JsonResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET(ApiChapters.PREFIX_TRENDING + ApiChapters.API_KEY_SUFFIX + ApiChapters.LIMIT_GIFS + ApiChapters.RATING)
    fun getTrendingGifs(): Call<JsonResponse?>?
}