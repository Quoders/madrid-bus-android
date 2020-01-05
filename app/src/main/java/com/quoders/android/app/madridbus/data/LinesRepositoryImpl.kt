package com.quoders.android.app.madridbus.data

import com.quoders.android.app.madridbus.data.remote.EmtService
import com.quoders.android.app.madridbus.domain.ILinesRepository
import com.quoders.android.app.madridbus.domain.model.Line
import com.quoders.android.app.madridbus.domain.model.Route
import com.quoders.android.app.madridbus.domain.model.Stop
import javax.inject.Inject

class LinesRepositoryImpl @Inject constructor(
    private val repositoryCache: RepositoryCache,
    private val loginRepository: LoginRepositoryImpl,
    private val emtService: EmtService
) : ILinesRepository {

    override suspend fun getAllLines(): List<Line> {
        /*if (repositoryCache.isExpired()) {
            val today = getTodayInEmtServiceFormat()
            val lines = emtService.getLines(today, "")
        }*/

        loginRepository.getUserToken("", "")

        return mutableListOf()
    }

    override suspend fun getLineStops(): List<Stop> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getLineRoute(): Route {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}