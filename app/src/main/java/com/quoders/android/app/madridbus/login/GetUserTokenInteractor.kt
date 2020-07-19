package com.quoders.android.app.madridbus.login

import com.quoders.android.app.madridbus.BuildConfig
import com.quoders.android.app.madridbus.core.functional.Either
import com.quoders.android.app.madridbus.core.functional.Failure
import com.quoders.android.app.madridbus.core.functional.Failure.FeatureFailure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetUserTokenInteractor constructor(
    private val loginRepository: ILoginRepository,
    private val authTokenMapper: AuthTokenMapper
) {

    suspend fun execute(): Either<FeatureFailure, AuthToken>? {
        var authToken: AuthToken? = null
        withContext(Dispatchers.IO) {
            val userToken =
                loginRepository.getUserToken(BuildConfig.EMT_USER, BuildConfig.EMT_PASSWORD)
            //userToken.fold(::processError, processSuccess)
        }
        return null
    }

    private fun processSuccess() {
        TODO("Not yet implemented")
    }

    private fun processError(failure: Failure) {
        TODO("Not yet implemented")
    }

}

