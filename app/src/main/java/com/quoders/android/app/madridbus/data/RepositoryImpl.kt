package com.quoders.android.app.madridbus.data

import com.quoders.android.app.madridbus.core.getTodayInEmtServiceFormat
import com.quoders.android.app.madridbus.data.api.EmtService
import com.quoders.android.app.madridbus.data.model.LineEntity
import com.quoders.android.app.madridbus.data.model.RouteEntity
import com.quoders.android.app.madridbus.data.model.StopEntity
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    val repositoryCache: RepositoryCache,
    val emtService: EmtService
) : Repository {

    override suspend fun getAllLines(): List<LineEntity> {
        if (repositoryCache.isExpired()) {
            val today = getTodayInEmtServiceFormat()
            val lines = emtService.getLines(today, "")
        }
        return mutableListOf()
    }

    override suspend fun getLineStops(): List<StopEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getLineRoute(): RouteEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}