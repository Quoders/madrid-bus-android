package com.quoders.android.app.madridbus.data

import com.quoders.android.app.madridbus.data.model.LineEntity
import com.quoders.android.app.madridbus.data.model.RouteEntity
import com.quoders.android.app.madridbus.data.model.StopEntity

class RepositoryImpl: Repository {

    override suspend fun getAllLines(): List<LineEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getLineStops(): List<StopEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getLineRoute(): RouteEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}