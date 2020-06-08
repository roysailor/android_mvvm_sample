package com.medleyone.news.home.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.medleyone.news.home.data.model.Article
import com.medleyone.news.home.data.model.TopHeadlineResponse
import com.medleyone.news.home.data.net.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository: NewsRepositoryInterface {

    private val retrofitClient = RetrofitClient()

    override fun getTopHeadlines(country: String): LiveData<List<Article>> {

        val data = MutableLiveData<List<Article>>()

        retrofitClient.getTopHeadlines(country).enqueue(object : Callback<TopHeadlineResponse>{
            override fun onFailure(call: Call<TopHeadlineResponse>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<TopHeadlineResponse>,
                response: Response<TopHeadlineResponse>
            ) {

                data.value = response.body()?.articles

            }

        })

        return data

    }
}