package com.quoders.android.app.madridbus.lines

import com.quoders.android.app.madridbus.data.EmtService
import com.quoders.android.app.madridbus.data.RepositoryCache
import com.quoders.android.app.madridbus.login.ILoginRepository
import com.quoders.android.app.madridbus.route.Route
import com.quoders.android.app.madridbus.route.Stop
import javax.inject.Inject

class LinesRepositoryImpl @Inject constructor(
    private val repositoryCache: RepositoryCache,
    private val loginRepository: ILoginRepository,
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