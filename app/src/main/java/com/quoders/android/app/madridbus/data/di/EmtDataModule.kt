package com.quoders.android.app.madridbus.data.di

import com.quoders.android.app.madridbus.data.api.EmtService
import com.quoders.android.app.madridbus.data.api.EmtService.Companion.EMT_ENDPOINT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Module
class EmtDataModule {

    @Provides
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
}