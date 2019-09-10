package com.quoders.android.app.madridbus.core

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper(context: Context) {

    companion object {
        private val PREF_MADRID_BUS_PACKAGE_NAME = "com.quoders.android.app.madridbus"
        private val PREF_KEY_LAST_CACHE = "last_cache"
    }

    private val preferences: SharedPreferences

    init {
        preferences = context.getSharedPreferences(
            PREF_MADRID_BUS_PACKAGE_NAME,
            Context.MODE_PRIVATE
        )
    }

    var lastCacheTime: Long
        get() = preferences.getLong(PREF_KEY_LAST_CACHE, 0)
        set(value) = preferences.edit().putLong(PREF_KEY_LAST_CACHE, value).apply()
}