package com.anggitprayogo.kotlinmultiplatformproject.ui.main

import com.anggitprayogo.kotlinmultiplatformproject.domain.Response
import domain.model.NewsResponse

sealed class GetNewsByDomainState {
    abstract val response: Response<NewsResponse>?
}

data class SuccessGetNewsByDomainState(override val response: Response<NewsResponse>) :
    GetNewsByDomainState()

data class LoadingGetNewsBydomainState(override val response: Response<NewsResponse>? = null) :
    GetNewsByDomainState()

data class ErrorGetWeatherByLocationState(override val response: Response<NewsResponse>) :
    GetNewsByDomainState()
