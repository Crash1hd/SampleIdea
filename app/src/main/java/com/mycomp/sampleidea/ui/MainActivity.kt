package com.mycomp.sampleidea.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mycomp.sampleidea.R
import com.mycomp.sampleidea.utilities.SampleIdea
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import kotlin.coroutines.CoroutineContext

class MainActivity : ScopedAppActivity(), KodeinAware {
    override val kodein by kodein()//This used to be closest Kodein

    private val sampleIdeaModelFactory:SampleIdeaViewModelFactory by instance()

    private lateinit var sampleIdeaViewModel: SampleIdeaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Use ViewModelProviders class to create / get already created SampleIdeaViewModel
        // for this view (activity)
        sampleIdeaViewModel = ViewModelProviders.of(this, sampleIdeaModelFactory)
            .get(SampleIdeaViewModel::class.java)

        SampleIdea.sampleSave("Dave")
        bindUI()
    }

    private fun bindUI() = launch {
        val currentWeather = sampleIdeaViewModel.allEntries.await()
        currentWeather.observe(this@MainActivity, Observer {
            if(it == null) return@Observer

            textView.text = it.toString()
        })
    }
}

abstract class ScopedAppActivity: AppCompatActivity(), CoroutineScope {
    private lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}