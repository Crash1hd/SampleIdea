package com.mycomp.sampleidea.utilities

import com.mycomp.sampleidea.data.entitiy.SampleIdeaEntry
import com.mycomp.sampleidea.ui.SampleIdeaViewModel

object SampleIdea {
    private lateinit var sampleIdeaViewModel: SampleIdeaViewModel

    fun sampleSave(name:String) {
        insertIntoSampleIdeaDatabase(createSampleIdeaEntry(name))
    }

    private fun createSampleIdeaEntry(name:String) = SampleIdeaEntry(name)

    private fun insertIntoSampleIdeaDatabase(sie:SampleIdeaEntry) {
        sampleIdeaViewModel.upsert(sie)
    }

    fun setSampleIdeaViewModel(sivm: SampleIdeaViewModel) {
        sampleIdeaViewModel = sivm
    }
}