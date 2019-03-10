package com.mycomp.sampleidea.data.repository

import androidx.lifecycle.LiveData
import com.mycomp.sampleidea.data.entitiy.SampleIdeaEntity

interface SampleIdeaRepository {
    suspend fun getAllEntries(): LiveData<List<SampleIdeaEntity>>

    suspend fun upsert(sampleIdeaEntity: SampleIdeaEntity): List<Long>
}