package com.mbamgn.moviecatalogue.ui.main

import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MainViewModelTest {

    private lateinit var viewModel: MainViewModel


    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun getRandomMovie() {
        val movieEntities = viewModel.getRandomMovie()
        assertNotNull(movieEntities)
    }
}