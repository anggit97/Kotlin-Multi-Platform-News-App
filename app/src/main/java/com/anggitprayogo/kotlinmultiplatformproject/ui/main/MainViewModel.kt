package com.anggitprayogo.kotlinmultiplatformproject.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anggitprayogo.kotlinmultiplatformproject.domain.Response
import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.news.GetNewsByDomainRequest
import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.news.GetNewsByDomainUseCase
import com.anggitprayogo.kotlinmultiplatformproject.utils.launchSilent
import domain.model.NewsResponse
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainViewModel @Inject constructor(
    private val getNewsByDomainUseCase: GetNewsByDomainUseCase,
    private val coroutineContext: CoroutineContext
) : ViewModel() {

    private var job: Job = Job()

    var getNewsByDomainLiveData = MutableLiveData<NewsResponse>()
    var getError = MutableLiveData<String>()

    fun getNewsByDomain(domain: String) = launchSilent(coroutineContext, job) {
        val request = GetNewsByDomainRequest(domain)
        val response = getNewsByDomainUseCase.execute(request)
        processNewsByDomainRespone(response)
    }

    private fun processNewsByDomainRespone(response: Response<NewsResponse>) {
        if (response is Response.Success) {
            getNewsByDomainLiveData.postValue(response.data)
        } else if (response is Response.Error) {
            getError.postValue(response.exception.message)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}