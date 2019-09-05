package com.quoders.android.app.madridbus.data.model.login


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "accessToken")
    val accessToken: String,
    @Json(name = "apiCounter")
    val apiCounter: ApiCounter,
    @Json(name = "email")
    val email: String,
    @Json(name = "idUser")
    val idUser: String,
    @Json(name = "tokenSecExpiration")
    val tokenSecExpiration: Int,
    @Json(name = "updatedAt")
    val updatedAt: String,
    @Json(name = "userName")
    val userName: String
)