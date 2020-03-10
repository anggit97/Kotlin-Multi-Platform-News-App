package com.anggitprayogo.kotlinmultiplatformproject.presentation.profile

import com.anggitprayogo.kotlinmultiplatformproject.ApplicationDispatcher
import com.anggitprayogo.kotlinmultiplatformproject.domain.Response
import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.profile.GetProfileUserUseCase
import com.anggitprayogo.kotlinmultiplatformproject.presentation.BasePresenter
import domain.model.profile.UserProfileResponse
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ProfilePresenter(
    private val userProfileUserUseCase: GetProfileUserUseCase,
    coroutineContext: CoroutineContext = ApplicationDispatcher
) : BasePresenter<ProfileView>(coroutineContext) {


    override fun onViewAttached(view: ProfileView) {
        super.onViewAttached(view)
    }

    fun getProfile() {
        view?.showLoading(true)
        scope.launch {
            val response = userProfileUserUseCase.execute()
            if (response is Response.Success) {
                view?.onSuccessGetProfile(response.data)
            } else if (response is Response.Error) {
                view?.onErrorGetProfile(response.exception)
            }
            view?.showLoading(false)
        }
    }
}

interface ProfileView {

    fun showLoading(visibility: Boolean)

    fun onSuccessGetProfile(data: UserProfileResponse)

    fun onErrorGetProfile(exception: Throwable)
}