package com.mbamgn.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import com.mbamgn.moviecatalogue.BuildConfig
import com.mbamgn.moviecatalogue.model.DataItem
import com.mbamgn.moviecatalogue.data.retrofit.Api
import com.mbamgn.moviecatalogue.data.retrofit.Client
import com.mbamgn.moviecatalogue.model.ItemResponse
import com.mbamgn.moviecatalogue.utils.Espresso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RemoteDataSource(private val retrofit: Api = Client.create()){

    companion object {
        private const val TIME: Long = 1500
    }

    private val apiKey = BuildConfig.TOKEN
    private var handler = Handler(Looper.getMainLooper())

    interface ListMovieCallback {
        fun onResponse(response: List<DataItem>)
    }

    interface ListTvShowCallback {
        fun onResponse(response: List<DataItem>)
    }

    interface MovieDetailCallback {
        fun onResponse(response: DataItem)
    }

    interface TvShowDetailCallback {
        fun onResponse(response: DataItem)
    }

    fun getMovieList(callback: ListMovieCallback) {
        Espresso.increment()
        handler.postDelayed({
            retrofit.listMovie(apiKey).enqueue(object : Callback<ItemResponse>{
                override fun onResponse(
                    call: Call<ItemResponse>,
                    response: Response<ItemResponse>,
                ) {
                    val final = response.body()?.result
                    callback.onResponse(final!!)
                    Espresso.decrement()
                }

                override fun onFailure(call: Call<ItemResponse>, t: Throwable) {

                }
            })
        }, TIME)

    }

    fun getDetailMovie(id: Int, callback: MovieDetailCallback) {
       Espresso.increment()
        handler.postDelayed({
            retrofit.detailMovie(id, apiKey).enqueue(object : Callback<DataItem>{
                override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                    callback.onResponse(response.body()!!)
                    Espresso.decrement()
                }

                override fun onFailure(call: Call<DataItem>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }, TIME)
    }

    fun getTvShowList(callback: ListTvShowCallback){
        Espresso.increment()
        handler.postDelayed({
            retrofit.listTvShow(apiKey).enqueue(object: Callback<ItemResponse> {
                override fun onResponse(
                    call: Call<ItemResponse>,
                    response: Response<ItemResponse>,
                ) {
                    val final = response.body()?.result
                    callback.onResponse(final!!)
                    Espresso.decrement()
                }

                override fun onFailure(call: Call<ItemResponse>, t: Throwable) {

                }

            })
        }, TIME)
    }

    fun getDetailTv(id: Int, callback: TvShowDetailCallback) {
        Espresso.increment()
        handler.postDelayed({
            retrofit.detailTvShow(id, apiKey).enqueue(object : Callback<DataItem>{
                override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                    callback.onResponse(response.body()!!)
                    Espresso.decrement()
                }

                override fun onFailure(call: Call<DataItem>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
        }, TIME)
    }

}