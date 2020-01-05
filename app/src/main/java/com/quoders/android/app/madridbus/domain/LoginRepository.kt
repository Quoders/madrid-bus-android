package com.quoders.android.app.madridbus.domain

import com.quoders.android.app.madridbus.core.Either
import com.quoders.android.app.madridbus.core.Failure

interface LoginRepository {
    suspend fun getUserToken(user: String, pass: String) : Either<Failure, String>
}
