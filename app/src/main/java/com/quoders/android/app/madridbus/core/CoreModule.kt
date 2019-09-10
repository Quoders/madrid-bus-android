package com.quoders.android.app.madridbus.core

import android.content.Context
import com.quoders.android.app.madridbus.MainActivity
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule {

    @Singleton
    @Provides
    fun providesContext(mainActivity: MainActivity): Context = mainActivity.applicationContext

    @Singleton
    @Provides
    fun providePreferencesHelper(context: Context): PreferencesHelper = PreferencesHelper(context)
}