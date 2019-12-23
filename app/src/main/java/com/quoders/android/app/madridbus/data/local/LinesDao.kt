package com.quoders.android.app.madridbus.data.local

import androidx.room.Dao
import androidx.room.Query
import com.quoders.android.app.madridbus.data.local.LineEntity

@Dao
interface LinesDao {

    @Query("SELECT * from lines ORDER BY code ASC")
    fun getAllLines(): List<LineEntity>
}