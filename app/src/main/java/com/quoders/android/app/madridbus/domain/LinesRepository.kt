package com.quoders.android.app.madridbus.domain

import com.quoders.android.app.madridbus.domain.model.Line
import com.quoders.android.app.madridbus.domain.model.Route
import com.quoders.android.app.madridbus.domain.model.Stop

interface LinesRepository {

    suspend fun getAllLines(): List<Line>

    suspend fun getLineStops(): List<Stop>

    suspend fun getLineRoute(): Route
}