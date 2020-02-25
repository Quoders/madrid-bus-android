package com.quoders.android.app.madridbus.domain.lines

import com.quoders.android.app.madridbus.domain.route.Route
import com.quoders.android.app.madridbus.domain.route.Stop

interface ILinesRepository {

    suspend fun getAllLines(): List<Line>

    suspend fun getLineStops(): List<Stop>

    suspend fun getLineRoute(): Route
}