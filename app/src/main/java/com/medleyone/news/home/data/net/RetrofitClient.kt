package com.medleyone.news.home.data.net

import com.medleyone.news.BuildConfig
import com.medleyone.news.home.data.model.TopHeadlineResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val newsApi: NewsApi

    init {


        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClientBuilder = OkHttpClient.Builder()

        okHttpClientBuilder.addInterceptor(httpLoggingInterceptor)
        okHttpClientBuilder.addInterceptor(AccessTokenInterceptor(BuildConfig.NEWS_API_KEY))

        val okHttpClient = okHttpClientBuilder.build()

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)


        val retrofit = retrofitBuilder.build()

        newsApi = retrofit.create(NewsApi::class.java)

    }

    fun getTopHeadlines(country: String): Call<TopHeadlineResponse>{

        return newsApi.getTopHeadlines(country)

    }

    companion object{

        private const val API_URL = "https://newsapi.org"

    }

}