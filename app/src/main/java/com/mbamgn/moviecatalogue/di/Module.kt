package com.mbamgn.moviecatalogue.di

import com.mbamgn.moviecatalogue.ui.movie.MovieFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {
    viewModel<MovieFragmentViewModel>()


}