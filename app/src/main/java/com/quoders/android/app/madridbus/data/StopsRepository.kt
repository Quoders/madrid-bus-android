package com.quoders.android.app.madridbus.data

import com.google.android.gms.maps.model.LatLng
import com.quoders.android.app.madridbus.core.functional.Failure
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

        loginRepository.getUserToken("", "")
            //.fold(::onLoginError)

        return stops
    }

    private suspend fun getStops(location: LatLng, token: String) {
        emtService.getStopsAroundMe(
            location.latitude,
            location.longitude,
            token
        )
    }

    private fun onLoginError(failure: Failure) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}