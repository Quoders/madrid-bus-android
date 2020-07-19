package com.quoders.android.app.madridbus.route

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StopEntity(
    @PrimaryKey var code: String,
    var name: String,
    var latitute: Double,
    var longitude: Double
)