package com.mycomp.sampleidea.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mycomp.sampleidea.data.entitiy.SampleIdeaEntry

@Database(entities = [SampleIdeaEntry::class], version = 1)
abstract class SampleIdeaDatabase : RoomDatabase() {
    abstract fun sampleIdeaDao(): SampleIdeaDao

    companion object {
        @Volatile
        private var instance: SampleIdeaDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, SampleIdeaDatabase::class.java, "forecast.db").build()
    }
}