package com.quoders.android.app.madridbus.lines

import com.quoders.android.app.madridbus.route.Route
import com.quoders.android.app.madridbus.route.Stop

interface ILinesRepository {

    suspend fun getAllLines(): List<Line>

    suspend fun getLineStops(): List<Stop>

    suspend fun getLineRoute(): Route
}