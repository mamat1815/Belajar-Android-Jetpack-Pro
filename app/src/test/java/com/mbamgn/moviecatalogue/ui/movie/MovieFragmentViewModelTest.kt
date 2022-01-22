package com.mbamgn.moviecatalogue.ui.movie

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MovieFragmentViewModelTest {

    private lateinit var viewModel: MovieFragmentViewModel

    @Before
    fun setUp() {
        viewModel = MovieFragmentViewModel()
    }

    @Test
    fun getMovie() {
        val movieEntities = viewModel.getMovie()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)

    }
}