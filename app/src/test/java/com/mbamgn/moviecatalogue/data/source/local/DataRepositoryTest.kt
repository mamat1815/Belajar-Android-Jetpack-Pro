package com.mbamgn.moviecatalogue.data.source.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mbamgn.moviecatalogue.data.source.remote.RemoteDataSource
import com.mbamgn.moviecatalogue.utils.DataDummy
import com.mbamgn.moviecatalogue.utils.LiveDataTest
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class DataRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val repository = FakeDataRepository(remote)

    private val responseMovie = DataDummy.generateDummyMovie()
    private val responseTvShow = DataDummy.generateDummyTvShow()
    private val dataMovie = responseMovie[0]
    private val dataTvShow = responseMovie[0]
    private val idMovie = dataMovie.id
    private val idTvShow = dataMovie.id

    @Test
    fun getMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.ListMovieCallback)
                .onResponse(responseMovie)
            null
        }.`when`(remote).getMovieList(any())
        val movieEntities = LiveDataTest.getValue(repository.getMovie())
        verify(remote).getMovieList(any())
        assertNotNull(movieEntities)
    }

    @Test
    fun getTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.ListTvShowCallback)
                .onResponse(responseTvShow)
            null
        }.`when`(remote).getTvShowList(any())
        val tvShowEntities = LiveDataTest.getValue(repository.getTvShow())
        verify(remote).getTvShowList(any())
        assertNotNull(tvShowEntities)
    }

    @Test
    fun getDetailData() {
        val typeMovie = "movie"
        val typeTvShow = "tv_show"

        doAnswer { invocation ->
            (invocation.arguments as RemoteDataSource.MovieDetailCallback)
                .onResponse(dataMovie)
            null
        }.`when`(remote).getDetailMovie(eq(idMovie), any())

        doAnswer { invocation ->
            (invocation.arguments as RemoteDataSource.TvShowDetailCallback)
                .onResponse(dataTvShow)
            null
        }.`when`(remote).getDetailMovie(eq(idTvShow), any())

        val detailMovieData = LiveDataTest.getValue(repository.getDetailData(eq(idMovie), eq(typeMovie)))
        val detailTvSHowData = LiveDataTest.getValue(repository.getDetailData(eq(idTvShow), eq(typeTvShow)))

        verify(remote).getDetailMovie(eq(idMovie), any())
        verify(remote).getDetailTv(eq(idTvShow), any())
        assertNotNull(detailMovieData)
    }

}