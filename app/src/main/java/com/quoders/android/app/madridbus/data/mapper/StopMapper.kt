package com.quoders.android.app.madridbus.data.mapper

import com.quoders.android.app.madridbus.data.local.StopEntity
import com.quoders.android.app.madridbus.data.remote.AroundStopsApiData

class StopMapper {
    fun mapToStopList(stopsApiData: AroundStopsApiData): List<StopEntity> {
        val stops = mutableListOf<StopEntity>()

        return stops
    }
}
