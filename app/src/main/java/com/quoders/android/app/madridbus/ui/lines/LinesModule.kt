package com.quoders.android.app.madridbus.ui.lines

import androidx.lifecycle.ViewModel
import com.quoders.android.app.madridbus.core.di.ViewModelFactoryModule
import com.quoders.android.app.madridbus.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelFactoryModule::class])
abstract class LinesModule {

    @Binds
    @IntoMap
    @ViewModelKey(LinesViewModel::class)
    abstract fun bindLinesViewModel(viewModel: LinesViewModel): ViewModel

    @ContributesAndroidInjector
    abstract fun contributesLinesFragment(): LinesFragment
}