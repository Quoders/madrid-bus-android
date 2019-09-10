package com.quoders.android.app.madridbus.di

import com.quoders.android.app.madridbus.MainActivity
import com.quoders.android.app.madridbus.core.CoreModule
import com.quoders.android.app.madridbus.data.di.EmtDataModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class AndroidInjectBuilder {
    @Singleton
    @ContributesAndroidInjector(modules = [EmtDataModule::class, CoreModule::class])
    abstract fun bindMainActivity(): MainActivity
}