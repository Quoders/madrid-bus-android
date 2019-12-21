package com.quoders.android.app.madridbus.data.lines

import com.quoders.android.app.madridbus.core.getTodayInEmtServiceFormat
import com.quoders.android.app.madridbus.data.RepositoryCache
import com.quoders.android.app.madridbus.data.lines.remote.EmtService
import com.quoders.android.app.madridbus.domain.LinesRepository
import com.quoders.android.app.madridbus.domain.model.Line
import com.quoders.android.app.madridbus.domain.model.Route
import com.quoders.android.app.madridbus.domain.model.Stop
import javax.inject.Inject

class LinesRepositoryImpl @Inject constructor(
    private val repositoryCache: RepositoryCache,
    private val emtService: EmtService
) : LinesRepository {

    override suspend fun getAllLines(): List<Line> {
        if (repositoryCache.isExpired()) {
            val today = getTodayInEmtServiceFormat()
            val lines = emtService.getLines(today, "")
        }
        return mutableListOf()
    }

    override suspend fun getLineStops(): List<Stop> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getLineRoute(): Route {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}