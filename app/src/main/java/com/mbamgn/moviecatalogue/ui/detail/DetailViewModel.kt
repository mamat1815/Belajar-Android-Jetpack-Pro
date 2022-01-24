package com.mbamgn.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.BuildConfig
import com.mbamgn.moviecatalogue.data.retrofit.Api
import com.mbamgn.moviecatalogue.data.retrofit.Client
import com.mbamgn.moviecatalogue.model.DataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    private val _detailMovie =  MutableLiveData<DataItem>()
    val detailMovie : LiveData<DataItem> = _detailMovie

    private val _p  = MutableLiveData<String>()
    val p : LiveData<String> = _p

    private val retrofit: Api = Client.create()
    private val apiKey = BuildConfig.TOKEN
    private val movieType = "movie"

    fun getDetailMovie(type: String, id: Int) {

        if (type == movieType) {

            retrofit.detailMovie(id, apiKey).enqueue(object : Callback<DataItem>{
                override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                    _detailMovie.value = response.body()
                }

                override fun onFailure(call: Call<DataItem>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        } else {

            retrofit.detailTvShow(id, apiKey).enqueue(object : Callback<DataItem>{
                override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                    _detailMovie.value = response.body()
                }

                override fun onFailure(call: Call<DataItem>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }

    }
    /*

    fun getDetailMovie(id: Int) {
        retrofit.detailMovie(id, apiKey).enqueue(object : Callback<DataItem>{
            override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                _detailMovie.value = response.body()
            }

            override fun onFailure(call: Call<DataItem>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

     */


}