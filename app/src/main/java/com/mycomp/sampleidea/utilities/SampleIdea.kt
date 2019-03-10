package com.mycomp.sampleidea.utilities

import com.mycomp.sampleidea.data.entitiy.SampleIdeaEntity
import com.mycomp.sampleidea.ui.SampleIdeaViewModel

object SampleIdea {
    private lateinit var sampleIdeaViewModel: SampleIdeaViewModel

    fun sampleSave(name:String) {
        insertIntoSampleIdeaDatabase(createSampleIdeaEntry(name))
    }

    private fun createSampleIdeaEntry(name:String) = SampleIdeaEntity(name=name)

    private fun insertIntoSampleIdeaDatabase(sie:SampleIdeaEntity) {
        sampleIdeaViewModel.upsert(sie)
    }

    fun setSampleIdeaViewModel(sivm: SampleIdeaViewModel) {
        sampleIdeaViewModel = sivm
    }
}