package com.medleyone.news.home.data.model

data class Article(
    var source: NewsSource,
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String,
    var content: String
)