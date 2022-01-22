package com.mbamgn.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.BuildConfig
import com.mbamgn.moviecatalogue.data.Api
import com.mbamgn.moviecatalogue.data.Client
import com.mbamgn.moviecatalogue.model.DataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    private lateinit var id: String

    private val _detailMovie =  MutableLiveData<DataItem>()
    val detailMovie : LiveData<DataItem> = _detailMovie

    private val retrofit: Api = Client.create()
    private val apiKey = BuildConfig.TOKEN

    fun getDetailMovie(id: Int) {
        retrofit.detailMovie(apiKey, id).enqueue(object : Callback<DataItem>{
            override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                _detailMovie.value = response.body()
            }

            override fun onFailure(call: Call<DataItem>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun setDetailMovie(movieId: String) {
        this.id = movieId
    }




}