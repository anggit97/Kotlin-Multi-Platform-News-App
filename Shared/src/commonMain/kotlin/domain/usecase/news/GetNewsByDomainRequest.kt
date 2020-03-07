package com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.news

import com.anggitprayogo.kotlinmultiplatformproject.domain.usecase.base.BaseRequest

class GetNewsByDomainRequest(var domain: String) : BaseRequest {
    override fun validate(): Boolean {
        return true
    }
}