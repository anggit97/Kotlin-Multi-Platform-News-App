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

            http.get<HttpRequestBuilder> {
                header("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvZGV2Lm5nYW1wb296LmNvbVwvYXBpXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU4MzI5MTI2NSwiZXhwIjoxNTk4ODQzMjY1LCJuYmYiOjE1ODMyOTEyNjUsImp0aSI6IlZWWVp4OGc0N0VBZXlKY3giLCJzdWIiOjEyOTI1NSwicHJ2IjoiODdlMGFmMWVmOWZkMTU4MTJmZGVjOTcxNTNhMTRlMGIwNDc1NDZhYSJ9.9NlfeEHjKAGgUzB0o3HOXaBZkdrph06j3v3vDhl2gDM")
            }

            val url =
                ApiConfig.baseUrlNgampooz.plus("profile/me")
            val json = http.get<String>(url)
            val newsResponse = Json.nonstrict.parse(UserProfileResponse.serializer(), json)

            Response.Success(newsResponse)
        } catch (ex: Exception) {
            Response.Error(ex)
        }
    }
}