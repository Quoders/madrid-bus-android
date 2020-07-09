package com.quoders.android.app.madridbus.data

import com.quoders.android.app.madridbus.core.PreferencesHelper

class RepositoryCache constructor(private val preferencesHelper: PreferencesHelper) {

    fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdate = preferencesHelper.lastCacheTime
        return currentTime - lastUpdate > CACHE_EXPIRATION_TIME
    }

    companion object {
        private const val CACHE_EXPIRATION_TIME = (60 * 10 * 1000).toLong()
    }
}