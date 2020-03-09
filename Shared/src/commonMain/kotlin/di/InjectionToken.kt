package com.anggitprayogo.kotlinmultiplatformproject.di

import com.anggitprayogo.kotlinmultiplatformproject.source.network.NewsApi

object InjectionToken {

    var newsApi = NewsApi()

    fun injectToken(token: String) = newsApi.setToken(token)

    fun getInjectToken() = newsApi.getToken()
}