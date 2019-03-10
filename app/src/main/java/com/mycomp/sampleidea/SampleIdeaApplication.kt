package com.mycomp.sampleidea

import android.app.Application
import android.util.Log
import com.jakewharton.threetenabp.AndroidThreeTen
import com.mycomp.sampleidea.data.db.SampleIdeaDatabase
import com.mycomp.sampleidea.data.repository.SampleIdeaRepository
import com.mycomp.sampleidea.data.repository.SampleIdeaRepositoryImpl
import com.mycomp.sampleidea.ui.SampleIdeaViewModel
import com.mycomp.sampleidea.ui.SampleIdeaViewModelFactory
import com.mycomp.sampleidea.utilities.SampleIdea
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.instance
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class SampleIdeaApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@SampleIdeaApplication))

        //Bind the Database
        bind() from singleton { SampleIdeaDatabase(instance()) }//This calls the ForecastDatabase.invoke function passes in the instance of the androidX application

        //Bind The Dao
        bind() from singleton { instance<SampleIdeaDatabase>().sampleIdeaDao() }

        //Binding the Forecast Repository Interface with its Implementation
        bind<SampleIdeaRepository>() with singleton { SampleIdeaRepositoryImpl(instance()) }

        bind() from provider { SampleIdeaViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)

        initializer()
    }

    private fun initializer() {

        val sampleIdeaViewModelFactory:SampleIdeaViewModelFactory by instance()

        val sampleIdeaVIewModel: SampleIdeaViewModel = sampleIdeaViewModelFactory.create(SampleIdeaViewModel::class.java)
        SampleIdea.setSampleIdeaViewModel(sampleIdeaVIewModel)

    }
}