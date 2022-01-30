package com.mbamgn.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mbamgn.moviecatalogue.data.source.DataItem
import com.mbamgn.moviecatalogue.data.source.remote.RemoteDataSource

class DataRepository(private val remoteDataSource: RemoteDataSource) : DataSource {

    companion object {
        @Volatile
        private var INSTANCE: DataRepository? = null

        fun getInstance(remoteRepository: RemoteDataSource): DataRepository? {
            if (INSTANCE == null) {
                synchronized(DataRepository::class.java) {
                    if (INSTANCE == null)
                        INSTANCE = DataRepository(remoteRepository)
                }
            }
            return INSTANCE
        }
    }

    val onLoading = MutableLiveData<Boolean>()

    override fun getMovie(): LiveData<List<DataItem>> {
        val listMovie = MutableLiveData<List<DataItem>>()

        onLoading.value = true
        remoteDataSource.getMovieList(object : RemoteDataSource.ListMovieCallback {
            override fun onResponse(response: List<DataItem>) {
                if (response.isNullOrEmpty()) {
                    onLoading.value = false
                } else {
                    onLoading.value = false
                    listMovie.value = response
                }
            }
        })
        return listMovie
    }

    override fun getTvShow(): LiveData<List<DataItem>> {
        val listTvShow = MutableLiveData<List<DataItem>>()

        onLoading.value = true
        remoteDataSource.getTvShowList(object : RemoteDataSource.ListTvShowCallback {
            override fun onResponse(response: List<DataItem>) {
                onLoading.value = false
                listTvShow.value = response

            }

        })
        return listTvShow
    }

    override fun getDetailData(id: Int, type: String): LiveData<DataItem> {
        val detailData = MutableLiveData<DataItem>()
        val types = "movie"
        if (type == types) {
            onLoading.value = true
            remoteDataSource.getDetailMovie(id, object : RemoteDataSource.MovieDetailCallback {
                override fun onResponse(response: DataItem) {
                    onLoading.value = false
                    detailData.value = response
                }
            })
        } else {
            onLoading.value = true
            remoteDataSource.getDetailTv(id, object : RemoteDataSource.TvShowDetailCallback {
                override fun onResponse(response: DataItem) {
                    onLoading.value = false
                    detailData.value = response
                }
            })
        }
        return detailData
    }

}