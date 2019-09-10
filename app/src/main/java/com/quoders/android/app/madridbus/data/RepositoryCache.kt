package com.quoders.android.app.madridbus.data

import com.quoders.android.app.madridbus.core.PreferencesHelper
import javax.inject.Inject

class RepositoryCache @Inject constructor(private val preferencesHelper: PreferencesHelper) {

    private val CACHE_EXPIRATION_TIME = (60 * 10 * 1000).toLong()

    fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdate = preferencesHelper.lastCacheTime
        return currentTime - lastUpdate > CACHE_EXPIRATION_TIME
    }

}