package com.mbamgn.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.mbamgn.moviecatalogue.data.source.DataItem
import com.mbamgn.moviecatalogue.data.source.local.DataRepository
import com.mbamgn.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MovieFragmentViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private lateinit var viewModel: MovieFragmentViewModel

    @Mock
    private lateinit var repository: DataRepository

    //private var repository = Mockito.mock(DataRepository::class.java)

    @Before
    fun setUp() {
        viewModel = MovieFragmentViewModel(repository)
    }

    @Test
    fun getListMovie() {
        val listMovie = MutableLiveData<List<DataItem>>()
        listMovie.value = DataDummy.generateDummyMovie()
        Mockito.`when`(repository.getMovie()).thenReturn(listMovie)
        Mockito.verify<DataRepository>(repository).getMovie()
    }

    @Test
    fun getLoad() {
    }
}