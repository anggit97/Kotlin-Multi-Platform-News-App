package com.anggitprayogo.kotlinmultiplatformproject.ui

import android.util.Log.v
import androidx.multidex.MultiDexApplication
import com.anggitprayogo.kotlinmultiplatformproject.app.di.component.ApplicationComponent
import com.anggitprayogo.kotlinmultiplatformproject.app.di.component.DaggerApplicationComponent
import com.anggitprayogo.kotlinmultiplatformproject.app.di.module.ApplicationModule
import com.anggitprayogo.kotlinmultiplatformproject.source.network.NewsApi
import com.anggitprayogo.kotlinmultiplatformproject.source.network.NgampoozApi

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
        NgampoozApi.invoke()
        NgampoozApi.token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczpcL1wvZGV2Lm5nYW1wb296LmNvbVwvYXBpXC9hdXRoXC9sb2dpbiIsImlhdCI6MTU4MzI5MTI2NSwiZXhwIjoxNTk4ODQzMjY1LCJuYmYiOjE1ODMyOTEyNjUsImp0aSI6IlZWWVp4OGc0N0VBZXlKY3giLCJzdWIiOjEyOTI1NSwicHJ2IjoiODdlMGFmMWVmOWZkMTU4MTJmZGVjOTcxNTNhMTRlMGIwNDc1NDZhYSJ9.9NlfeEHjKAGgUzB0o3HOXaBZkdrph06j3v3vDhl2gDM"
    }

    private fun initializeDagger() {
        graph = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }
}