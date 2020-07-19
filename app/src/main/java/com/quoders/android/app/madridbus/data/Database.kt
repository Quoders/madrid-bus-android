package com.quoders.android.app.madridbus.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.quoders.android.app.madridbus.lines.LinesDao

abstract class Database : RoomDatabase() {

    abstract fun linesDao(): LinesDao

    companion object {

        @Volatile
        private var INSTANCE: Database? = null

        fun getDatabase(context: Context): Database {

            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Database::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}