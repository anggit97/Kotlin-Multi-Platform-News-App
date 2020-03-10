package com.anggitprayogo.kotlinmultiplatformproject.source.repository

import com.anggitprayogo.kotlinmultiplatformproject.domain.Response
import com.anggitprayogo.kotlinmultiplatformproject.source.network.NgampoozApi
import domain.model.profile.UserProfileResponse

class UserProfileRepository(
    private val ngampoozApi: NgampoozApi
) {

    suspend fun getProfile() : Response<UserProfileResponse>{
        return ngampoozApi.getProfile()
    }
}