package com.quoders.android.app.madridbus.data.lines.remote

import com.quoders.android.app.madridbus.data.lines.remote.model.LinesApiData
import com.quoders.android.app.madridbus.data.login.remote.model.LoginApiData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path


interface EmtService {

    @GET("v1/mobilitylabs/user/login/")
    suspend fun login(
        @Header("email") email: String,
        @Header("password") password: String
    ): Response<LoginApiData>

    @GET("v1/transport/busemtmad/lines/info/{date}/")
    suspend fun getLines(
        @Path("date") fromDate: String,
        @Header("accessToken") userkey: String
    ): Response<LinesApiData>

    companion object {
        const val EMT_ENDPOINT = "https://openapi.emtmadrid.es/"
    }
}
