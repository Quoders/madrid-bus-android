package com.quoders.android.app.madridbus.data.di

import com.quoders.android.app.madridbus.domain.lines.LinesRepository
import com.quoders.android.app.madridbus.data.RepositoryCache
import com.quoders.android.app.madridbus.data.LinesRepositoryImpl
import com.quoders.android.app.madridbus.data.api.EmtService
import com.quoders.android.app.madridbus.data.api.EmtService.Companion.EMT_ENDPOINT
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
    fun provideDesignerNewsService(): EmtService {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
            .baseUrl(EMT_ENDPOINT)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
            .create(EmtService::class.java)
    }

    @Provides
    @Singleton
    fun providesRepository(
        repositoryCache: RepositoryCache,
        emtService: EmtService
    ): LinesRepository {
        return LinesRepositoryImpl(repositoryCache, emtService)
    }
}