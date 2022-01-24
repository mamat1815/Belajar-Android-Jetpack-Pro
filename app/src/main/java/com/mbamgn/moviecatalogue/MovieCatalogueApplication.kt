package com.mbamgn.moviecatalogue

import android.app.Application
import com.mbamgn.moviecatalogue.di.module
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MovieCatalogueApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MovieCatalogueApplication)
            modules(module)
        }
    }

}