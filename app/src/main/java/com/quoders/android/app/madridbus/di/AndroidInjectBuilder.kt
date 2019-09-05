package com.quoders.android.app.madridbus.di

import com.quoders.android.app.madridbus.MainActivity
import com.quoders.android.app.madridbus.data.di.EmtDataModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidInjectBuilder {
    @ContributesAndroidInjector(modules = [EmtDataModule::class])
    abstract fun bindMainActivity(): MainActivity
}