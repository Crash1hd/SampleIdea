package com.mycomp.sampleidea.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mycomp.sampleidea.data.repository.SampleIdeaRepository

class SampleIdeaViewModelFactory(private val sampleIdeaRepository: SampleIdeaRepository) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SampleIdeaViewModel(sampleIdeaRepository) as T
    }

}