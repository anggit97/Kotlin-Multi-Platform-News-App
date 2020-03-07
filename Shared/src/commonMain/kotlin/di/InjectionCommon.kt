package com.anggitprayogo.kotlinmultiplatformproject.di

import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.news.GetNewsByDomainUseCase
import com.anggitprayogo.kotlinmultiplatformproject.presentation.news.NewsPresenter
import com.anggitprayogo.kotlinmultiplatformproject.source.network.NewsApi
import com.anggitprayogo.kotlinmultiplatformproject.source.repository.NewsRepository
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object InjectionCommon {

    private val newsApi: NewsApi by lazy { NewsApi() }

    private val newsRepository: NewsRepository by lazy {
        NewsRepository(newsApi)
    }

    fun provideGetNewsUseCase() : GetNewsByDomainUseCase{
        return GetNewsByDomainUseCase(newsRepository)
    }


    /**
     * Presenter
     */
    fun provideNewsPresenter() : NewsPresenter{
        return NewsPresenter(provideGetNewsUseCase())
    }
}