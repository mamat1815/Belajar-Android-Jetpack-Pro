package com.mbamgn.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.BuildConfig
import com.mbamgn.moviecatalogue.data.Api
import com.mbamgn.moviecatalogue.data.Client
import com.mbamgn.moviecatalogue.model.DataItem
import com.mbamgn.moviecatalogue.model.ItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieFragmentViewModel : ViewModel() {

    private val _listMovie = MutableLiveData<List<DataItem>>()
    val listDataItem: LiveData<List<DataItem>> = _listMovie

    private val _p = MutableLiveData<String>()
    val p: LiveData<String> = _p

    private val retrofit: Api = Client.create()
    private val apiKey = BuildConfig.TOKEN

    fun getListMovie() {
        retrofit.listMovie(apiKey).enqueue(object: Callback<ItemResponse>{
            override fun onResponse(
                call: Call<ItemResponse>,
                response: Response<ItemResponse>,
            ) {
                    _listMovie.value = response.body()?.result
            }

            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                _p.value = "fail"
            }

        })
    }

}