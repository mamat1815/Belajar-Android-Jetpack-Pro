package com.mbamgn.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.BuildConfig
import com.mbamgn.moviecatalogue.data.retrofit.Api
import com.mbamgn.moviecatalogue.data.retrofit.Client
import com.mbamgn.moviecatalogue.data.source.local.DataRepository
import com.mbamgn.moviecatalogue.data.source.remote.RemoteDataSource
import com.mbamgn.moviecatalogue.model.DataItem
import com.mbamgn.moviecatalogue.model.ItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieFragmentViewModel(private val repository: DataRepository) : ViewModel() {

    fun getListMovie() :LiveData<List<DataItem>> = repository.getMovie()

}