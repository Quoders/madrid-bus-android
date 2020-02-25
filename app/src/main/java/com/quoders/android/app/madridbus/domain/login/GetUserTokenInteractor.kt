package com.quoders.android.app.madridbus.domain.login

import javax.inject.Inject

class GetUserTokenInteractor @Inject constructor(
    private val loginRepository: ILoginRepository,
    private val authTokenMapper: AuthTokenMapper
) {

    suspend fun execute(): AuthToken {
        val userToken = loginRepository.getUserToken("david.guerrero@quoders.com", "oisi28Emt\$")
        return authTokenMapper.map(userToken)
    }
}