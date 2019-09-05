package com.quoders.android.app.madridbus.data.model.lines

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "endDate")
    val endDate: String,
    @Json(name = "group")
    val group: String,
    @Json(name = "label")
    val label: String,
    @Json(name = "line")
    val line: String,
    @Json(name = "nameA")
    val nameA: String,
    @Json(name = "nameB")
    val nameB: String,
    @Json(name = "startDate")
    val startDate: String
)