package com.quoders.android.app.madridbus.data.lines

import androidx.room.Dao
import androidx.room.Query
import com.quoders.android.app.madridbus.data.lines.LineEntity

@Dao
interface LinesDao {

    @Query("SELECT * from lines ORDER BY code ASC")
    fun getAllLines(): List<LineEntity>
}