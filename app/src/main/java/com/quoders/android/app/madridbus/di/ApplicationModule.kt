package com.quoders.android.app.madridbus.di

import com.quoders.android.app.madridbus.core.PreferencesHelper
import com.quoders.android.app.madridbus.data.EmtService
import com.quoders.android.app.madridbus.data.RepositoryCache
import com.quoders.android.app.madridbus.data.lines.LinesRepositoryImpl
import com.quoders.android.app.madridbus.data.login.LoginRepositoryImpl
import com.quoders.android.app.madridbus.domain.lines.ILinesRepository
import com.quoders.android.app.madridbus.domain.login.ILoginRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RemoteDataSource

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    fun provideEmtService(): EmtService {

        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(EmtService.EMT_ENDPOINT)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(EmtService::class.java)
    }

    @Provides
    fun providesRepositoryCache(preferencesHelper: PreferencesHelper): RepositoryCache {
        return RepositoryCache(preferencesHelper)
    }

    @Module
    @InstallIn(ApplicationComponent::class)
    abstract class LoginModule {
        @Binds
        abstract fun providesLoginRepository(loginRepositoryImpl: LoginRepositoryImpl)
                : ILoginRepository

        @Binds
        abstract fun bindLinesRepository(
            linesRepositoryImpl: LinesRepositoryImpl
        ): ILinesRepository
    }
}