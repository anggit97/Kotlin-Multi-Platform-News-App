package com.anggitprayogo.kotlinmultiplatformproject.source.network

import com.anggitprayogo.kotlinmultiplatformproject.apiconfig.ApiConfig
import com.anggitprayogo.kotlinmultiplatformproject.domain.Response
import domain.model.NewsResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json

class NewsApi {

    val http = HttpClient()

    private lateinit var token: String

    fun setToken(token: String) {
        this.token = token
    }

    fun getToken() = token

    suspend fun getNews(domain: String): Response<NewsResponse> {
        return try {
            val url =
                ApiConfig.baseUrl.plus("everything?domains=$domain&apiKey=${ApiConfig.apiKey}")
            val json = http.get<String>(url)
            val newsResponse = Json.nonstrict.parse(NewsResponse.serializer(), json)

            Response.Success(newsResponse)
        } catch (ex: Exception) {
            Response.Error(ex)
        }
    }
}