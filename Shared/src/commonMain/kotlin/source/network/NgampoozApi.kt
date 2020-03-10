package com.anggitprayogo.kotlinmultiplatformproject.source.network

import com.anggitprayogo.kotlinmultiplatformproject.apiconfig.ApiConfig
import com.anggitprayogo.kotlinmultiplatformproject.domain.Response
import domain.model.profile.UserProfileResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.get
import io.ktor.client.request.header
import kotlinx.serialization.json.Json
import kotlin.jvm.Volatile
import kotlin.native.concurrent.ThreadLocal

class NgampoozApi {

    val http = HttpClient()

    @ThreadLocal
    companion object {
        @Volatile
        private var instances: NgampoozApi? = null

        operator fun invoke() = instances ?: NgampoozApi()
        var token: String? = null
    }

    suspend fun getProfile(): Response<UserProfileResponse> {
        return try {
            token
            val url =
                ApiConfig.baseUrlNgampooz.plus("profile/me")
            val json = http.get<String>(url) {
                header("Authorization", "Bearer $token")
                header("Accept", "application/json")
            }
            val newsResponse = Json.nonstrict.parse(UserProfileResponse.serializer(), json)

            Response.Success(newsResponse)
        } catch (ex: Exception) {
            Response.Error(ex)
        }
    }
}