package com.quoders.android.app.madridbus.domain.route

import com.google.android.gms.maps.model.LatLng
import com.quoders.android.app.madridbus.data.route.StopEntity

interface IStopsRespository {

    suspend fun getStopsAroundMe(location: LatLng): List<StopEntity>
}