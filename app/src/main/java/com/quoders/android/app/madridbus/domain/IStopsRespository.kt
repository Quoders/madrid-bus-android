package com.quoders.android.app.madridbus.domain

import com.google.android.gms.maps.model.LatLng
import com.quoders.android.app.madridbus.data.local.StopEntity

interface IStopsRespository {

    suspend fun getStopsAroundMe(location: LatLng): List<StopEntity>
}