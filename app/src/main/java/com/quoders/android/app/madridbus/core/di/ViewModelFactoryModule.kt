package com.quoders.android.app.madridbus.core.di

import androidx.lifecycle.ViewModelProvider
import com.quoders.android.app.madridbus.core.functional.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}