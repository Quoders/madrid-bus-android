package com.quoders.android.app.madridbus.domain.lines

import com.quoders.android.app.madridbus.data.model.LineEntity
import com.quoders.android.app.madridbus.data.model.RouteEntity
import com.quoders.android.app.madridbus.data.model.StopEntity

interface LinesRepository {

    suspend fun getAllLines(): List<LineEntity>

    suspend fun getLineStops(): List<StopEntity>

    suspend fun getLineRoute(): RouteEntity
}