package com.quoders.android.app.madridbus.ui.home.di

import com.quoders.android.app.madridbus.data.login.LoginRepositoryImpl
import com.quoders.android.app.madridbus.domain.login.AuthTokenMapper
import com.quoders.android.app.madridbus.domain.login.GetUserTokenInteractor
import dagger.Module
import dagger.Provides

@Module
object HomeModule {

    @Provides
    @JvmStatic
    fun providesAuthTokenMapper(): AuthTokenMapper {
        return AuthTokenMapper()
    }

    @Provides
    @JvmStatic
    fun providesGetUserTokenInteractor(
        loginRepository: LoginRepositoryImpl,
        authTokenMapper: AuthTokenMapper
    ): GetUserTokenInteractor {
        return GetUserTokenInteractor(loginRepository, authTokenMapper)
    }
}