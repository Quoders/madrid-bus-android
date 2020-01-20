package com.quoders.android.app.madridbus.domain

import com.quoders.android.app.madridbus.core.functional.Either
import com.quoders.android.app.madridbus.core.functional.Failure

interface LoginRepository {
    suspend fun getUserToken(user: String, pass: String) : Either<Failure, String>
}
