package com.quoders.android.app.madridbus.di

import com.quoders.android.app.madridbus.ui.MainActivity
import com.quoders.android.app.madridbus.ui.lines.LinesModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = [LinesModule::class])
    abstract fun bindMainActivity(): MainActivity
}