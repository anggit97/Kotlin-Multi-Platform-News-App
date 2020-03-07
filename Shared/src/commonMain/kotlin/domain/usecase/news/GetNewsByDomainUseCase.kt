package com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.news

import com.anggitprayogo.kotlinmultiplatformproject.domain.Response
import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.base.BaseUseCase
import com.anggitprayogo.kotlinmultiplatformproject.source.repository.NewsRepository
import domain.model.NewsResponse
import kotlinx.serialization.UnstableDefault

open class GetNewsByDomainUseCase(
    val repository: NewsRepository
) : BaseUseCase<GetNewsByDomainRequest, NewsResponse>() {

    @UnstableDefault
    override suspend fun run(): Response<NewsResponse> {
        return repository.getNews(request?.domain!!)
    }
}