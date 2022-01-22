package com.mbamgn.moviecatalogue.ui.detail_tv_show

import com.mbamgn.moviecatalogue.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        viewModel = DetailTvShowViewModel()
        viewModel.setDetailTvShow(tvShowId)
    }

    @Test
    fun getDetailTvShow() {
        val tvShowEntities = viewModel.getDetailTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShow.tvShowId, tvShowEntities?.tvShowId)
        assertEquals(dummyTvShow.desc, tvShowEntities?.desc)
        assertEquals(dummyTvShow.title, tvShowEntities?.title)
        assertEquals(dummyTvShow.tag, tvShowEntities?.tag)
        assertEquals(dummyTvShow.percentage, tvShowEntities?.percentage)
        assertEquals(dummyTvShow.genre, tvShowEntities?.genre)
        assertEquals(dummyTvShow.img, tvShowEntities?.img)
    }


}