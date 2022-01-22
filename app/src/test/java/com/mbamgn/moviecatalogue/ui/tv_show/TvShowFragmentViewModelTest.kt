package com.mbamgn.moviecatalogue.ui.tv_show

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TvShowFragmentViewModelTest {

    private lateinit var viewModel: TvShowFragmentViewModel

    @Before
    fun setUp() {
        viewModel = TvShowFragmentViewModel()
    }

    @Test
    fun getTvShow() {
        val tvShowEntities = viewModel.getTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(10, tvShowEntities.size)
    }
}