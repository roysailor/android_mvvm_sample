package com.medleyone.news.home.viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.medleyone.news.home.data.NewsRepository
import com.medleyone.news.home.data.model.Article

class HomeViewModel(private val newsRepository: NewsRepository = NewsRepository()): ViewModel() {

    private val topHeadLines = MediatorLiveData<List<Article>>()

    init {
        fetchTopHeadlines()
    }

    fun getTopHeadlines() = topHeadLines

    public fun fetchTopHeadlines(){

        topHeadLines.addSource(newsRepository.getTopHeadlines("in", 10, 1)){ articles ->

            topHeadLines.postValue(articles)

        }

    }

}