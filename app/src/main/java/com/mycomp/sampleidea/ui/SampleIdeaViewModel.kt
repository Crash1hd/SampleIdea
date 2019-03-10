package com.mycomp.sampleidea.ui

import androidx.lifecycle.ViewModel
import com.mycomp.sampleidea.data.entitiy.SampleIdeaEntity
import com.mycomp.sampleidea.data.repository.SampleIdeaRepository
import com.mycomp.sampleidea.utilities.lazyDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class SampleIdeaViewModel(private val sampleIdeaRepository: SampleIdeaRepository): ViewModel() {
    val allEntries by lazyDeferred {
        sampleIdeaRepository.getAllEntries()
    }

    fun upsert(sampleIdeaEntity: SampleIdeaEntity):List<Long> = runBlocking {
        return@runBlocking withContext(Dispatchers.IO) {
            return@withContext sampleIdeaRepository.upsert(sampleIdeaEntity)
        }
    }
}
