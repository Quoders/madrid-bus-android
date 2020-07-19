package com.quoders.android.app.madridbus.route

import com.google.android.gms.maps.model.LatLng

interface IStopsRespository {

    suspend fun getStopsAroundMe(location: LatLng): List<StopEntity>
}