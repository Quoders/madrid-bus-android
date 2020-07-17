package com.quoders.android.app.madridbus.data.login

import com.quoders.android.app.madridbus.core.functional.Either
import com.quoders.android.app.madridbus.core.functional.Either.Left
import com.quoders.android.app.madridbus.core.functional.Failure
import com.quoders.android.app.madridbus.data.EmtService
import com.quoders.android.app.madridbus.domain.login.ILoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val emtService: EmtService) :
    ILoginRepository {

    override suspend fun getUserToken(user: String, pass: String): Either<Failure, String> {

        return try {
            val loginData = emtService.login(user, pass)
            when (loginData.code.toInt()) {
                80 -> return Left(LoginFailure.CredentialsError())
            }

            return Either.Right(loginData.userData[0].accessToken)
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError)
        }
    }
}