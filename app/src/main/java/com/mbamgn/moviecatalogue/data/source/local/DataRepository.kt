package com.mbamgn.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mbamgn.moviecatalogue.model.DataItem
import com.mbamgn.moviecatalogue.data.source.remote.RemoteDataSource

class DataRepository(private val remoteDataSource: RemoteDataSource): DataSource {

    override fun getMovie(): LiveData<List<DataItem>> {
        val listMovie = MutableLiveData<List<DataItem>>()
        remoteDataSource.getMovieList(object : RemoteDataSource.ListMovieCallback{
            override fun onResponse(response: List<DataItem>) {
                listMovie.value = response
            }
        })
        return listMovie
    }

    override fun getTvShow(): LiveData<List<DataItem>> {
        val listTvShow = MutableLiveData<List<DataItem>>()
        remoteDataSource.getTvShowList(object : RemoteDataSource.ListTvShowCallback {
            override fun onResponse(response: List<DataItem>) {
                listTvShow.value = response
            }

        })
        return listTvShow
    }

    override fun getDetailData(id: Int, type: String): LiveData<DataItem> {
        val detailData = MutableLiveData<DataItem>()
        val types = "movie"
        if (type == types) {
            remoteDataSource.getDetailMovie(id, object :RemoteDataSource.MovieDetailCallback{
                override fun onResponse(response: DataItem) {
                    detailData.value = response
                }
            } )
        } else {
            remoteDataSource.getDetailTv(id, object :RemoteDataSource.TvShowDetailCallback{
                override fun onResponse(response: DataItem) {
                    detailData.value = response
                }
            })
        }
        return detailData
    }




}