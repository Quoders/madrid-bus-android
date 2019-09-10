package com.quoders.android.app.madridbus.data

class RepositoryCache {

    private val CACHE_EXPIRATION_TIME = (60 * 10 * 1000).toLong()

    fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdate = this.getLastCachedTimeMillis()
        return currentTime - lastUpdate > CACHE_EXPIRATION_TIME
    }

    private fun getLastCachedTimeMillis(): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}