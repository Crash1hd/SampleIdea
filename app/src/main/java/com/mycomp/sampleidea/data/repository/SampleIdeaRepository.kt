package com.mycomp.sampleidea.data.repository

import androidx.lifecycle.LiveData
import com.mycomp.sampleidea.data.entitiy.SampleIdeaEntry

interface SampleIdeaRepository {
    suspend fun getAllEntries(): LiveData<SampleIdeaEntry>

    suspend fun upsert(sampleIdeaEntry: SampleIdeaEntry): List<Long>
}