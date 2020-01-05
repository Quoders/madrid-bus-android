package com.quoders.android.app.madridbus.data

import com.quoders.android.app.madridbus.core.Either
import com.quoders.android.app.madridbus.core.Either.Left
import com.quoders.android.app.madridbus.core.Either.Right
import com.quoders.android.app.madridbus.core.Failure
import com.quoders.android.app.madridbus.data.failure.LoginFailure
import com.quoders.android.app.madridbus.data.remote.EmtService
import com.quoders.android.app.madridbus.domain.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val emtService: EmtService) :
    LoginRepository {

    override suspend fun getUserToken(user: String, pass: String): Either<Failure, String> {

        return try {
            val loginData = emtService.login(user, pass)
            when(loginData.code.toInt()) {
                80 -> return Left(LoginFailure.CredentialsError())
            }

            return Either.Right(loginData.userData[0].accessToken)
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError)
        }
    }
}