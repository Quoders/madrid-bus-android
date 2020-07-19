package com.quoders.android.app.madridbus.lines

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lines")
data class LineEntity(

    @PrimaryKey
    var code: String,

    var name: String
)