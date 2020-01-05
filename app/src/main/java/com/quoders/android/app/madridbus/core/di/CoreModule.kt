package com.quoders.android.app.madridbus.core.di

import android.content.Context
import com.quoders.android.app.madridbus.core.PreferencesHelper
import com.quoders.android.app.madridbus.ui.MainActivity
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
    fun providePreferencesHelper(context: Context): PreferencesHelper =
        PreferencesHelper(context)
}