package com.quoders.android.app.madridbus.data.remote

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface EmtService {

    @GET(EMT_PATH_LOGIN)
    suspend fun login(
        @Header("email") email: String,
        @Header("password") password: String
    ): LoginApiData

    @GET("v1/transport/busemtmad/lines/info/{date}/")
    suspend fun getLines(
        @Path("date") fromDate: String,
        @Header("accessToken") userkey: String
    ): LinesApiData

    @GET("v1/transport/busemtmad/stops/arroundxy/{latitude}/{longitude}/200")
    suspend fun getStopsAroundMe(
        @Path("latitude") latitude: Double,
        @Path("longitude") longitude: Double,
        @Header("accessToken") userkey: String
    ): AroundStopsApiData


    companion object {
        const val EMT_ENDPOINT = "https://openapi.emtmadrid.es/"

        const val EMT_PATH_LOGIN = "v1/mobilitylabs/user/login/"
    }
}
