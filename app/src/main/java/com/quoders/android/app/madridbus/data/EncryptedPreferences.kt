package com.quoders.android.app.madridbus.data

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class EncryptedPreferences constructor(private val applicationContext: Context) {

    private var sharedPreferences: SharedPreferences? = null

    init {
        initialise()
    }

    fun putString(key: String, value: String) =
        sharedPreferences?.edit()?.putString(key, value)?.apply()

    fun getString(key: String): String = sharedPreferences?.getString(key, "")!!

    private fun initialise() {

        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

        sharedPreferences = EncryptedSharedPreferences.create(
            PREFS_FILENAME,
            masterKeyAlias,
            applicationContext,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

    companion object {
        private const val PREFS_FILENAME = "mbus_prefs"
    }
}