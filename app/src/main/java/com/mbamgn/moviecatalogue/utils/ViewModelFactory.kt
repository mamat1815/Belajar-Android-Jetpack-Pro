package com.mbamgn.moviecatalogue.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mbamgn.moviecatalogue.data.source.local.DataRepository
import com.mbamgn.moviecatalogue.di.Injection
import com.mbamgn.moviecatalogue.ui.movie.MovieFragmentViewModel
import com.mbamgn.moviecatalogue.ui.tv_show.TvShowFragmentViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val dataRepository: DataRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory? {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = ViewModelFactory(Injection.dataRepository())

                    }
                }

            }
            return INSTANCE
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieFragmentViewModel::class.java) -> MovieFragmentViewModel(
                dataRepository) as T
            modelClass.isAssignableFrom(TvShowFragmentViewModel::class.java) -> TvShowFragmentViewModel(
                dataRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel: " + modelClass.name)
        }

    }

}