package com.anggitprayogo.kotlinmultiplatformproject.di

import com.anggitprayogo.kotlinmultiplatformproject.source.network.NewsApi

class InjectionToken {

    companion object{
        val INSTANCE : NewsApi by lazy {
            NewsApi()
        }
    }

    var token: String = ""
}