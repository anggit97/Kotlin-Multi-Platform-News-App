package com.anggitprayogo.kotlinmultiplatformproject.presentation.news

import com.anggitprayogo.kotlinmultiplatformproject.ApplicationDispatcher
import com.anggitprayogo.kotlinmultiplatformproject.domain.Response
import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.news.GetNewsByDomainUseCase
import com.anggitprayogo.kotlinmultiplatformproject.presentation.BasePresenter
import domain.model.NewsResponse
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NewsPresenter(
    private val newsByDomainUseCase: GetNewsByDomainUseCase,
    coroutinecontext: CoroutineContext = ApplicationDispatcher
) : BasePresenter<NewsView>(coroutinecontext) {

    fun getNews(domain: String) {
        view?.showLoading(true)
        scope.launch {
            val response = newsByDomainUseCase.repository.getNews(domain)
            if (response is Response.Success) {
                view?.onSuccessGetNews(response.data)
            } else {
                view?.onErrorGetNews(Exception("tolol"))
            }
            view?.showLoading(false)
        }
    }
}

interface NewsView {
    fun showLoading(visible: Boolean)

    fun onSuccessGetNews(data: NewsResponse)
    fun onErrorGetNews(exception: Exception)
}