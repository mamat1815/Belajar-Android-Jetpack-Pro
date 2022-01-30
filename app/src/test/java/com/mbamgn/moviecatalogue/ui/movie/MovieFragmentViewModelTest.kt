package com.mbamgn.moviecatalogue.ui.movie

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
class MovieFragmentViewModelTest {

    private lateinit var viewModel: MovieFragmentViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: DataRepository

    @Mock
    private lateinit var observer: Observer<List<DataItem>>

    @Before
    fun setUp(){
        viewModel = MovieFragmentViewModel(repository)
    }

    @Test
    fun getListMovie() {
        val dummyMovie = DataDummy.generateDummyMovie()
        val movie = MutableLiveData<List<DataItem>>()
        movie.value = dummyMovie
        `when`(repository.getMovie()).thenReturn(movie)
        val movieEntities = viewModel.getListMovie().value
        verify(repository).getMovie()
        assertNotNull(movieEntities)
        assertEquals(dummyMovie.size.toLong(), movieEntities?.size?.toLong())
        viewModel.getListMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}