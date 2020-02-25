package com.quoders.android.app.madridbus.domain.login

import javax.inject.Inject

class GetUserTokenInteractor @Inject constructor(
    private val loginRepository: ILoginRepository,
    private val authTokenMapper: AuthTokenMapper
) {

    suspend fun execute(): AuthToken {
        val userToken = loginRepository.getUserToken("", "")
        return authTokenMapper.map(userToken)
    }
}