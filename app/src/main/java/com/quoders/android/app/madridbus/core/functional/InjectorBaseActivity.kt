package com.quoders.android.app.madridbus.core.functional

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

open class InjectorBaseActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(saveInstance: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(saveInstance)
    }

    override fun androidInjector(): AndroidInjector<Any>? {
        return androidInjector
    }
}
