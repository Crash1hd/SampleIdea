package com.mycomp.sampleidea.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mycomp.sampleidea.data.entitiy.SampleIdeaEntity

@Dao
interface SampleIdeaDao {

    @Query("select * from simple_idea")
    fun getAllEntries(): LiveData<List<SampleIdeaEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(vararg sampleIdeaEntity: SampleIdeaEntity): List<Long>

}