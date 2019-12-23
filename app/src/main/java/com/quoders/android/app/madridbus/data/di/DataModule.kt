package com.quoders.android.app.madridbus.data.di

import com.quoders.android.app.madridbus.BuildConfig
import com.quoders.android.app.madridbus.data.LinesRepositoryImpl
import com.quoders.android.app.madridbus.data.RepositoryCache
import com.quoders.android.app.madridbus.data.remote.EmtService
import com.quoders.android.app.madridbus.domain.LinesRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun provideEmtService(url: String): EmtService {

        val interceptor = HttpLoggingInterceptor()

        interceptor.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(EmtService::class.java)
    }

    @Provides
    @Singleton
    fun provideLinesRepository(
        repositoryCache: RepositoryCache,
        emtService: EmtService
    ): LinesRepository =
        LinesRepositoryImpl(repositoryCache, emtService)
}