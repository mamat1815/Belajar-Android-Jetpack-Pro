package com.mbamgn.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.data.MovieEntity
import com.mbamgn.moviecatalogue.utils.DataDummy

class MovieFragmentViewModel : ViewModel() {

    fun getMovie(): List<MovieEntity> = DataDummy.generateDummyMovie()

}