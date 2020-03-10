package com.anggitprayogo.kotlinmultiplatformproject.di

import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.news.GetNewsByDomainUseCase
import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.profile.GetProfileUserUseCase
import com.anggitprayogo.kotlinmultiplatformproject.presentation.news.NewsPresenter
import com.anggitprayogo.kotlinmultiplatformproject.presentation.profile.ProfilePresenter
import com.anggitprayogo.kotlinmultiplatformproject.source.network.NewsApi
import com.anggitprayogo.kotlinmultiplatformproject.source.network.NgampoozApi
import com.anggitprayogo.kotlinmultiplatformproject.source.repository.NewsRepository
import com.anggitprayogo.kotlinmultiplatformproject.source.repository.UserProfileRepository
import domain.model.profile.UserProfileResponse
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object InjectionCommon {

    private val newsApi: NewsApi by lazy { NewsApi() }

    private val newsRepository: NewsRepository by lazy {
        NewsRepository(newsApi)
    }

    fun provideGetNewsUseCase(): GetNewsByDomainUseCase {
        return GetNewsByDomainUseCase(newsRepository)
    }

    /**
     * Presenter
     */
    fun provideNewsPresenter(): NewsPresenter {
        return NewsPresenter(provideGetNewsUseCase())
    }


    /**
     * Ngampooz
     */
    private val ngampoozApi: NgampoozApi by lazy { NgampoozApi() }

    private val profileRepository: UserProfileRepository by lazy {
        UserProfileRepository(ngampoozApi)
    }

    fun provideGetProfileUseCase(): GetProfileUserUseCase {
        return GetProfileUserUseCase(profileRepository)
    }

    fun provideProfilePresenter(): ProfilePresenter {
        return ProfilePresenter(provideGetProfileUseCase())
    }
}