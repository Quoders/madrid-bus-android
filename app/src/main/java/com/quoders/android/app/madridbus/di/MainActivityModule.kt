package com.quoders.android.app.madridbus.di

import com.quoders.android.app.madridbus.ui.home.di.HomeViewBindingModule
import com.quoders.android.app.madridbus.ui.home.MainActivity
import com.quoders.android.app.madridbus.ui.lines.LinesModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [LinesModule::class, HomeViewBindingModule::class])
    abstract fun bindMainActivity(): MainActivity
}