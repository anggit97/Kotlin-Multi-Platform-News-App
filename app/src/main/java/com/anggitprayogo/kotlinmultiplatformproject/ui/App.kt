package com.anggitprayogo.kotlinmultiplatformproject.ui

import androidx.multidex.MultiDexApplication
import com.anggitprayogo.kotlinmultiplatformproject.app.di.component.ApplicationComponent
import com.anggitprayogo.kotlinmultiplatformproject.app.di.component.DaggerApplicationComponent
import com.anggitprayogo.kotlinmultiplatformproject.app.di.module.ApplicationModule
import com.anggitprayogo.kotlinmultiplatformproject.di.InjectionToken
import com.anggitprayogo.kotlinmultiplatformproject.source.network.NewsApi

open class App : MultiDexApplication() {

    companion object {
        lateinit var graph: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
        initToken()
    }

    private fun initToken() {
        val instance = NewsApi.INSTANCE
        instance.token = "BGST"
    }

    private fun initializeDagger() {
        graph = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}