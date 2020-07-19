package com.quoders.android.app.madridbus.domain

import com.google.android.gms.maps.model.LatLng
import com.nhaarman.mockitokotlin2.mock
import com.quoders.android.app.madridbus.login.LoginRepositoryImpl
import com.quoders.android.app.madridbus.route.StopsRepository
import com.quoders.android.app.madridbus.route.StopMapper
import com.quoders.android.app.madridbus.data.EmtService
import com.quoders.android.app.madridbus.route.IStopsRespository
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
            val stopsRepository: IStopsRespository =
                StopsRepository(
                    emtService,
                    loginRepositoryMock,
                    stopMapper
                )

            val stopsAroundMe = stopsRepository.getStopsAroundMe(LatLng(40.416819, -3.703792))

            assertTrue(stopsAroundMe.isNotEmpty())
        }
    }
}