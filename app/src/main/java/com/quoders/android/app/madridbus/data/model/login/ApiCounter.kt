package com.quoders.android.app.madridbus.data.model.login


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiCounter(
    @Json(name = "current")
    val current: Int,
    @Json(name = "dailyUse")
    val dailyUse: Int
)