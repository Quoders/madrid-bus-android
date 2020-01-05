package com.quoders.android.app.madridbus.data

import com.google.android.gms.maps.model.LatLng
import com.quoders.android.app.madridbus.data.local.StopEntity
import com.quoders.android.app.madridbus.data.mapper.StopMapper
import com.quoders.android.app.madridbus.data.remote.EmtService
import com.quoders.android.app.madridbus.domain.IStopsRespository
import javax.inject.Inject

class StopsRepository @Inject constructor(
    private val emtService: EmtService,
    private val loginRepository: LoginRepositoryImpl,
    private val stopMapper: StopMapper
) : IStopsRespository {

    override suspend fun getStopsAroundMe(location: LatLng): List<StopEntity> {
        val stops = mutableListOf<StopEntity>()

        loginRepository.getUserToken(
            "",
            ""
        ).let {
            val stopsAroundMe =
                emtService.getStopsAroundMe(
                    location.latitude,
                    location.longitude,
                    it
                )
        }

        return stops
    }
}