package com.quoders.android.app.madridbus.core.functional

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T) -> Unit) =
    liveData.observe(this, Observer(body))

fun <T : Any, L : LiveData<T>> LifecycleOwner.observeOnce(liveData: L, body: (T) -> Unit) =
    liveData.observe(this, object : Observer<T> {
        override fun onChanged(t: T) {
            t.run(body)
            liveData.removeObserver(this)
        }
    })

