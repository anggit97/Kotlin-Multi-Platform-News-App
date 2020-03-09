package com.anggitprayogo.kotlinmultiplatformproject.source.repository

import com.anggitprayogo.kotlinmultiplatformproject.domain.Response
import com.anggitprayogo.kotlinmultiplatformproject.source.network.NewsApi
import domain.model.NewsResponse

class NewsRepository(
    private val newsApi: NewsApi
) {

    suspend fun getNews(domain: String): Response<NewsResponse> {
        return newsApi.getNews(domain)
    }
}