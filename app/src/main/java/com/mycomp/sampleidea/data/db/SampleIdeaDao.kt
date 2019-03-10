package com.mycomp.sampleidea.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mycomp.sampleidea.data.entitiy.SampleIdeaEntry

@Dao
interface SampleIdeaDao {

    @Query("select * from simple_idea")
    fun getAllEntries(): LiveData<SampleIdeaEntry>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(vararg sampleIdeaEntry: SampleIdeaEntry): List<Long>

}