package com.quoders.android.app.madridbus.login

import com.quoders.android.app.madridbus.core.functional.Either
import com.quoders.android.app.madridbus.core.functional.Failure

interface ILoginRepository {
    suspend fun getUserToken(user: String, pass: String) : Either<Failure, String>
}
