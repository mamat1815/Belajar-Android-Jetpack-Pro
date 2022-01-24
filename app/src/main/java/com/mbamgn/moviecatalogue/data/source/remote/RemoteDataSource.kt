package com.mbamgn.moviecatalogue.data.source.remote

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mbamgn.moviecatalogue.BuildConfig
import com.mbamgn.moviecatalogue.data.source.DataSource
import com.mbamgn.moviecatalogue.model.DataItem
import com.mbamgn.moviecatalogue.data.retrofit.Api
import com.mbamgn.moviecatalogue.data.retrofit.Client
import com.mbamgn.moviecatalogue.model.ItemResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource(private val retrofit: Api = Client.create()): DataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            return instance!!
            }

    }

    private val apiKey = BuildConfig.TOKEN

    override fun getMovie(): LiveData<List<DataItem>> {
        val listMovie = MutableLiveData<List<DataItem>>()
        retrofit.listMovie(apiKey).enqueue(object : Callback<ItemResponse>{
            override fun onResponse(
                call: Call<ItemResponse>,
                response: Response<ItemResponse>,
            ) {
                listMovie.value = response.body()?.result
            }

            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {

            }
        })
        return listMovie
    }

    override fun getDetailMovie(id: Int): LiveData<DataItem> {
        val detailMovie = MutableLiveData<DataItem>()
        retrofit.detailMovie(id, apiKey).enqueue(object : Callback<DataItem>{
            override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                detailMovie.value = response.body()
            }

            override fun onFailure(call: Call<DataItem>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return detailMovie
    }

    override fun getTvShow(): LiveData<List<DataItem>> {
        val listTvShow = MutableLiveData<List<DataItem>>()
        retrofit.listTvShow(apiKey).enqueue(object: Callback<ItemResponse> {
            override fun onResponse(
                call: Call<ItemResponse>,
                response: Response<ItemResponse>,
            ) {
                listTvShow.value = response.body()?.result
            }

            override fun onFailure(call: Call<ItemResponse>, t: Throwable) {

            }

        })
        return listTvShow
    }

    override fun getDetailTv(id: Int): LiveData<DataItem> {
        val detailTvShow = MutableLiveData<DataItem>()
        retrofit.detailTvShow(id, apiKey).enqueue(object : Callback<DataItem>{
            override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                detailTvShow.value = response.body()
            }

            override fun onFailure(call: Call<DataItem>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return detailTvShow
    }

}