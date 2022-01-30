package com.mbamgn.moviecatalogue.ui.tv_show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.mbamgn.moviecatalogue.data.source.DataItem
import com.mbamgn.moviecatalogue.data.source.local.DataRepository
import com.mbamgn.moviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowFragmentViewModelTest {

    private lateinit var viewModel: TvShowFragmentViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: DataRepository

    @Mock
    private lateinit var observer: Observer<List<DataItem>>

    @Before
    fun setUp() {
        viewModel = TvShowFragmentViewModel(repository)
    }

    @Test
    fun getListTvShow() {
        val dummyTvShow = DataDummy.generateDummyTvShow()
        val tvShow = MutableLiveData<List<DataItem>>()
        tvShow.value = dummyTvShow
        `when`(repository.getTvShow()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getListTvShow().value
        verify(repository).getTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(dummyTvShow.size.toLong(), tvShowEntities?.size?.toLong())
        viewModel.getListTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}