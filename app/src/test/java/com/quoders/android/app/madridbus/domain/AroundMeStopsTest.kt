package com.quoders.android.app.madridbus.domain

import com.google.android.gms.maps.model.LatLng
import com.nhaarman.mockitokotlin2.mock
import com.quoders.android.app.madridbus.data.LoginRepositoryImpl
import com.quoders.android.app.madridbus.data.StopsRepository
import com.quoders.android.app.madridbus.data.mapper.StopMapper
import com.quoders.android.app.madridbus.data.remote.EmtService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test

class AroundMeStopsTest {

    @Test
    fun given_validLocation_when_getAroundMeStops_then_returnValidStopList() {

        val loginRepositoryMock = mock<LoginRepositoryImpl>()
        val emtService = mock<EmtService>()
        val stopMapper = mock<StopMapper>()

        runBlocking {
            val stopsRepository: IStopsRespository = StopsRepository(emtService, loginRepositoryMock, stopMapper)

            val stopsAroundMe = stopsRepository.getStopsAroundMe(LatLng(40.416819, -3.703792))

            assertTrue(stopsAroundMe.isNotEmpty())
        }
    }
}