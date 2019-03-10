package com.mycomp.sampleidea.data.repository

import androidx.lifecycle.LiveData
import com.mycomp.sampleidea.data.db.SampleIdeaDao
import com.mycomp.sampleidea.data.entitiy.SampleIdeaEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class SampleIdeaRepositoryImpl(private val sampleIdeaDao: SampleIdeaDao) : SampleIdeaRepository {

    override suspend fun getAllEntries(): LiveData<List<SampleIdeaEntity>> {
        return withContext(Dispatchers.IO) {
            return@withContext sampleIdeaDao.getAllEntries()
        }
    }

    override suspend fun upsert(sampleIdeaEntity: SampleIdeaEntity): List<Long> = runBlocking {
        withContext(Dispatchers.IO) {
            return@withContext sampleIdeaDao.upsert(sampleIdeaEntity)
        }
    }
}