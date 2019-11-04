package com.quoders.android.app.madridbus.di

import android.app.Application
import com.quoders.android.app.madridbus.MadridBusApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(modules = [AndroidInjectionModule::class, MainActivityModule::class])
interface ApplicationComponent : AndroidInjector<MadridBusApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}
