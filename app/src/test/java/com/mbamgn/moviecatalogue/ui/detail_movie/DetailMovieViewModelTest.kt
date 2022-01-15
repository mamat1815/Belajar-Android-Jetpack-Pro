package com.mbamgn.moviecatalogue.ui.detail_movie

import com.mbamgn.moviecatalogue.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.movieId

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setDetailMovie(movieId)
    }

    @Test
    fun getDetailMovie() {
        val movieEntities = viewModel.getDetailMovie()
        assertNotNull(movieEntities)
        assertEquals(dummyMovie.title, movieEntities?.title)
        assertEquals(dummyMovie.genre, movieEntities?.genre)
        assertEquals(dummyMovie.percentage, movieEntities?.percentage)
        assertEquals(dummyMovie.desc, movieEntities?.desc)
        assertEquals(dummyMovie.tag, movieEntities?.tag)
        assertEquals(dummyMovie.movieId, movieEntities?.movieId)
        assertEquals(dummyMovie.img, movieEntities?.img)
    }
}