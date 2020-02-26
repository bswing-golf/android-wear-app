package com.example.bswing_wear_os

import android.content.Context
import androidx.room.*

private const val DATABASE_NAME = "bswing-db"

@Database(entities = arrayOf(RoomSwing::class), version = 1, exportSchema = false)

@TypeConverters(RoomConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun roomDaoSwing(): DaoSwing

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
        }
    }
}