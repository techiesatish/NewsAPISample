package com.reposenergy.network

import com.reposenergy.data.models.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {


    @GET("/v2/top-headlines")
    suspend fun getNews(@Query("country")country: String,
                        @Query("apiKey") apiKey: String): Response<News>
}