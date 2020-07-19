package com.quoders.android.app.madridbus.lines

import androidx.room.Dao
import androidx.room.Query

@Dao
interface LinesDao {

    @Query("SELECT * from lines ORDER BY code ASC")
    fun getAllLines(): List<LineEntity>
}