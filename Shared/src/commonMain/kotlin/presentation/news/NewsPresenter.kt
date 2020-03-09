package com.anggitprayogo.kotlinmultiplatformproject.presentation.news

import com.anggitprayogo.kotlinmultiplatformproject.ApplicationDispatcher
import com.anggitprayogo.kotlinmultiplatformproject.domain.Response
import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.news.GetNewsByDomainRequest
import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.news.GetNewsByDomainUseCase
import com.anggitprayogo.kotlinmultiplatformproject.presentation.BasePresenter
import domain.model.NewsResponse
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NewsPresenter(
    private var newsByDomainUseCase: GetNewsByDomainUseCase,
    coroutinecontext: CoroutineContext = ApplicationDispatcher
) : BasePresenter<NewsView>(coroutinecontext) {

    override fun onViewAttached(view: NewsView) {

    }

    fun getNews(domain: String) {
        view?.showLoading(true)
        scope.launch {
            val request = GetNewsByDomainRequest(domain)
            val response = newsByDomainUseCase.execute(request)
            if (response is Response.Success) {
                view?.onSuccessGetNews(response.data)
            } else if (response is Response.Error) {
                view?.onErrorGetNews(response.exception)
            }
            view?.showLoading(false)
        }
    }
}

interface NewsView {
    fun showLoading(visible: Boolean)

    fun onSuccessGetNews(data: NewsResponse)
    fun onErrorGetNews(exception: Throwable)
}