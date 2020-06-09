package com.medleyone.news.home.data.net

import com.medleyone.news.home.data.model.TopHeadlineResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("v2/top-headlines")
    fun getTopHeadlines(@Query("country") country: String, @Query("pageSize") pageSize: Int, @Query("page") page: Int): Call<TopHeadlineResponse>

}