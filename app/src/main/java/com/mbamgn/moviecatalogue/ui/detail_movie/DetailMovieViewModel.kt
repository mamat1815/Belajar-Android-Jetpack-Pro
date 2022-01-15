package com.mbamgn.moviecatalogue.ui.detail_movie

import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.data.MovieEntity
import com.mbamgn.moviecatalogue.utils.DataDummy

class DetailMovieViewModel : ViewModel() {

    private lateinit var movieId: String

    fun setDetailMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getDetailMovie(): MovieEntity? {
        var movie: MovieEntity? = null
        for (movieEntity in DataDummy.generateDummyMovie()) {
            if (movieEntity.movieId == movieId) {
                movie = movieEntity
            }
        }
        return movie
    }

}