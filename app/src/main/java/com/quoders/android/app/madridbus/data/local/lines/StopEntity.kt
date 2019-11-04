package com.quoders.android.app.madridbus.data.local.lines

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StopEntity(
    @PrimaryKey var code: String,
    var name: String,
    var latitute: Double,
    var longitude: Double
)