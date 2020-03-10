package com.anggitprayogo.kotlinmultiplatformproject.app.di.module

import com.anggitprayogo.kotlinmultiplatformproject.di.InjectionCommon
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule{

    @Provides
    @Singleton
    fun provideGetNewsByDomainUseCase() = InjectionCommon.provideGetNewsUseCase()

    @Provides
    @Singleton
    fun provideGetProfileUseCase() = InjectionCommon.provideGetProfileUseCase()
}