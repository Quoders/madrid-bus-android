package com.quoders.android.app.madridbus.di

import com.quoders.android.app.madridbus.core.di.CoreModule
import com.quoders.android.app.madridbus.data.di.DataModule
import com.quoders.android.app.madridbus.ui.MainActivity
import com.quoders.android.app.madridbus.ui.lines.LinesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class MainActivityModule {
    @Singleton
    @ContributesAndroidInjector(modules = [DataModule::class, CoreModule::class])
    abstract fun bindMainActivity(): MainActivity

    @FeatureScope
    @ContributesAndroidInjector
    abstract fun bindLinesFragment(): LinesFragment
}