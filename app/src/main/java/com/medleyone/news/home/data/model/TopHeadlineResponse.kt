package com.medleyone.news.home.data.model

data class TopHeadlineResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)