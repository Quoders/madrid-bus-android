package com.quoders.android.app.madridbus.di

import android.app.Application
import com.quoders.android.app.madridbus.MadridBusApplication
import com.quoders.android.app.madridbus.core.di.CoreModule
import com.quoders.android.app.madridbus.data.di.DataModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        MainActivityModule::class,
        CoreModule::class,
        DataModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MadridBusApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
