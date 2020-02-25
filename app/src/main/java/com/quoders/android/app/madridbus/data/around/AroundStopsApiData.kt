package com.quoders.android.app.madridbus.data.around

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AroundStopsApiData(
    @Json(name = "code")
    val code: String,
    @Json(name = "data")
    val `data`: List<Data>,
    @Json(name = "datetime")
    val datetime: String,
    @Json(name = "description")
    val description: String
)

@JsonClass(generateAdapter = true)
data class Data(
    @Json(name = "stops")
    val stops: List<Stop>
)

@JsonClass(generateAdapter = true)
data class Stop(
    @Json(name = "dataLine")
    val dataLine: List<DataLine>,
    @Json(name = "geometry")
    val geometry: Geometry,
    @Json(name = "name")
    val name: String,
    @Json(name = "pmv")
    val pmv: Any,
    @Json(name = "postalAddress")
    val postalAddress: String,
    @Json(name = "stop")
    val stop: String
)

@JsonClass(generateAdapter = true)
data class DataLine(
    @Json(name = "dayType")
    val dayType: String,
    @Json(name = "direction")
    val direction: String,
    @Json(name = "headerA")
    val headerA: String,
    @Json(name = "headerB")
    val headerB: String,
    @Json(name = "label")
    val label: String,
    @Json(name = "line")
    val line: String,
    @Json(name = "maxFreq")
    val maxFreq: String,
    @Json(name = "minFreq")
    val minFreq: String,
    @Json(name = "startTime")
    val startTime: String,
    @Json(name = "stopTime")
    val stopTime: String
)

@JsonClass(generateAdapter = true)
data class Geometry(
    @Json(name = "coordinates")
    val coordinates: List<Double>,
    @Json(name = "type")
    val type: String
)