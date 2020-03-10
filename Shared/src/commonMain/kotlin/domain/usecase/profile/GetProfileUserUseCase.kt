package com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.profile

import com.anggitprayogo.kotlinmultiplatformproject.domain.Response
import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.base.BaseUseCase
import com.anggitprayogo.kotlinmultiplatformproject.source.repository.UserProfileRepository
import domain.model.profile.UserProfileResponse

open class GetProfileUserUseCase(
    private val userProfileRepository: UserProfileRepository
) : BaseUseCase<GetProfileRequest, UserProfileResponse>(){

    override suspend fun run(): Response<UserProfileResponse> {
        return userProfileRepository.getProfile()
    }
}