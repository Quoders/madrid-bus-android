package com.quoders.android.app.madridbus.di

import com.quoders.android.app.madridbus.MadridBusApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector


@Component(modules = [AndroidInjectionModule::class, AndroidInjectBuilder::class])
interface ApplicationComponent : AndroidInjector<MadridBusApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MadridBusApplication): Builder

        fun build(): ApplicationComponent
    }
}
