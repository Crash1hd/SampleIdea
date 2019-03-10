package com.mycomp.sampleidea.data.repository

import androidx.lifecycle.LiveData
import com.mycomp.sampleidea.data.db.SampleIdeaDao
import com.mycomp.sampleidea.data.entitiy.SampleIdeaEntry
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class SampleIdeaRepositoryImpl(private val sampleIdeaDao: SampleIdeaDao) : SampleIdeaRepository {

    override suspend fun getAllEntries(): LiveData<SampleIdeaEntry> {
        return withContext(Dispatchers.IO) {
            return@withContext sampleIdeaDao.getAllEntries()
        }
    }

    override suspend fun upsert(sampleIdeaEntry: SampleIdeaEntry): List<Long> = runBlocking {
        withContext(Dispatchers.IO) {
            return@withContext sampleIdeaDao.upsert(sampleIdeaEntry)
        }
    }
}