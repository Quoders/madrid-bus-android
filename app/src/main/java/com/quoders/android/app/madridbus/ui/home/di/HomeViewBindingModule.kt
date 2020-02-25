package com.quoders.android.app.madridbus.ui.home.di

import androidx.lifecycle.ViewModel
import com.quoders.android.app.madridbus.core.di.ViewModelFactoryModule
import com.quoders.android.app.madridbus.di.ViewModelKey
import com.quoders.android.app.madridbus.ui.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class, HomeModule::class])
abstract class HomeViewBindingModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindLinesViewModel(viewModel: HomeViewModel): ViewModel
}