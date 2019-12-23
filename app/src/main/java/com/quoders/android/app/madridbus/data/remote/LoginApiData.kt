package com.quoders.android.app.madridbus.data.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginApiData(
    @Json(name = "data")
    val userData: List<UserData>,
    @Json(name = "code")
    val code: String,
    @Json(name = "datetime")
    val datetime: String,
    @Json(name = "description")
    val description: String
)

@JsonClass(generateAdapter = true)
data class UserData(
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

@JsonClass(generateAdapter = true)
data class ApiCounter(
    @Json(name = "current")
    val current: Int,
    @Json(name = "dailyUse")
    val dailyUse: Int
)