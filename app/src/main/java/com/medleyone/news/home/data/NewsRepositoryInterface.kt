package com.medleyone.news.home.data

import androidx.lifecycle.LiveData
import com.medleyone.news.home.data.model.Article
import com.medleyone.news.home.data.model.TopHeadlineResponse

interface NewsRepositoryInterface {

    fun getTopHeadlines(country: String): LiveData<List<Article>>

}