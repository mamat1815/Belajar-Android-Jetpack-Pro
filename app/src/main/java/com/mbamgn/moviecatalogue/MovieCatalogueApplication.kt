package com.mbamgn.moviecatalogue

import android.app.Application
import com.mbamgn.moviecatalogue.data.retrofit.Api
import com.mbamgn.moviecatalogue.data.retrofit.Client
import com.mbamgn.moviecatalogue.data.source.local.DataRepository
import com.mbamgn.moviecatalogue.data.source.remote.RemoteDataSource
import com.mbamgn.moviecatalogue.di.module
import com.mbamgn.moviecatalogue.model.DataItem
import com.mbamgn.moviecatalogue.ui.movie.MovieFragmentViewModel
import com.mbamgn.moviecatalogue.ui.tv_show.TvShowFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.GlobalContext.get
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.scope.get
import org.koin.dsl.module

class MovieCatalogueApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            //androidLogger(Level.DEBUG)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(this@MovieCatalogueApplication)
            modules(listOf(retrofit, dataResponse, dataRepository, viewModelMovieFragment))
        }
    }
}

val retrofit = module {
    single { Client.create() }
}

val dataResponse = module {
    factory { RemoteDataSource(get())}
}

val dataRepository = module {
    factory { DataRepository(get()) }
}

val viewModelMovieFragment = module{
    viewModel{MovieFragmentViewModel(get())}
}
