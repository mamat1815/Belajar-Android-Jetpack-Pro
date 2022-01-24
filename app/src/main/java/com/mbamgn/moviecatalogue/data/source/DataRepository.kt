package com.mbamgn.moviecatalogue.data.source

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mbamgn.moviecatalogue.model.DataItem
import com.mbamgn.moviecatalogue.data.retrofit.Api
import com.mbamgn.moviecatalogue.data.retrofit.Client
import com.mbamgn.moviecatalogue.data.source.remote.RemoteDataSource

class DataRepository(private val retrofit: Api = Client.create() , private val remoteDataSource: RemoteDataSource): DataSource {
    override fun getMovie(): LiveData<List<DataItem>> {
        TODO("Not yet implemented")
    }


    override fun getDetailMovie(id: Int): LiveData<DataItem> {
        TODO("Not yet implemented")
    }

    override fun getTvShow(): LiveData<List<DataItem>> {
        TODO("Not yet implemented")
    }

    override fun getDetailTv(id: Int): LiveData<DataItem> {
        TODO("Not yet implemented")
    }
}