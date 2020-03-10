package com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.profile

import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.base.BaseRequest

class GetProfileRequest() : BaseRequest {
    override fun validate(): Boolean {
        return true
    }
}