package com.anggitprayogo.kotlinmultiplatformproject.app.di.module

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class UtilsModule {

    @Provides
    @Singleton
    fun provideCoroutineContext() = Dispatchers.Default as CoroutineContext
}