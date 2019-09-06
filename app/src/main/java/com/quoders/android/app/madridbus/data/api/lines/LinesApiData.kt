package com.quoders.android.app.madridbus.data.api.lines

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LinesApiData(
    @Json(name = "data")
    val `data`: List<Data>,
    @Json(name = "code")
    val code: String,
    @Json(name = "datetime")
    val datetime: String,
    @Json(name = "description")
    val description: String
)