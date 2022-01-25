package com.mbamgn.moviecatalogue.ui.tv_show

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.BuildConfig
import com.mbamgn.moviecatalogue.data.retrofit.Api
import com.mbamgn.moviecatalogue.data.retrofit.Client
import com.mbamgn.moviecatalogue.model.DataItem
import com.mbamgn.moviecatalogue.model.ItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowFragmentViewModel() : ViewModel() {

    private val _listTvShow = MutableLiveData<List<DataItem>>()
    val listMovie: LiveData<List<DataItem>> = _listTvShow

    private val retrofit: Api = Client.create()
    private val apiKey = BuildConfig.TOKEN

    fun getListTvShow() {
        retrofit.listTvShow(apiKey).enqueue(object: Callback<ItemResponse> {
            override fun onResponse(
                call: Call<ItemResponse>,
                response: Response<ItemResponse>,
            ) {
                _listTvShow.value = response.body()?.result
            }

            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {

            }

        })
    }

}