package com.anggitprayogo.kotlinmultiplatformproject.app.di.module

import com.anggitprayogo.kotlinmultiplatformproject.ui.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val app: App) {

    @Provides @Singleton
    fun provideApp() : App = app

//    @Provides @Singleton
//    fun provideNavigator() =
}