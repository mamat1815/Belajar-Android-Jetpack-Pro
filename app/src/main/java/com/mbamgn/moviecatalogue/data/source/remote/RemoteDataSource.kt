package com.mbamgn.moviecatalogue.data.source.remote

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.mbamgn.moviecatalogue.BuildConfig
import com.mbamgn.moviecatalogue.data.retrofit.Api
import com.mbamgn.moviecatalogue.data.retrofit.Client
import com.mbamgn.moviecatalogue.data.source.DataItem
import com.mbamgn.moviecatalogue.data.source.ItemResponse
import com.mbamgn.moviecatalogue.data.source.local.DataRepository
import com.mbamgn.moviecatalogue.utils.Espresso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RemoteDataSource(private val retrofit: Api = Client.create()) {

    companion object {
        private const val TIME: Long = 2000
        private val TAG = RemoteDataSource::class.java.toString()

        @Volatile
        private var INSTANCE: RemoteDataSource? = null

        fun getInstance(retrofit: Api): RemoteDataSource?{
            if (INSTANCE == null){
                synchronized(DataRepository::class.java){
                    if (INSTANCE == null)
                        INSTANCE = RemoteDataSource(retrofit)
                }
            }
            return INSTANCE
        }

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
            retrofit.listMovie(apiKey).enqueue(object : Callback<ItemResponse> {
                override fun onResponse(
                    call: Call<ItemResponse>,
                    response: Response<ItemResponse>,
                ) {
                    val final = response.body()?.result
                    callback.onResponse(final!!)
                    Espresso.decrement()
                }

                override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }
            })
        }, TIME)

    }

    fun getDetailMovie(id: Int, callback: MovieDetailCallback) {
        Espresso.increment()
        handler.postDelayed({
            retrofit.detailMovie(id, apiKey).enqueue(object : Callback<DataItem> {
                override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                    response.body()?.let { callback.onResponse(it) }
                    Espresso.decrement()
                }

                override fun onFailure(call: Call<DataItem>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }

            })
        }, TIME)
    }

    fun getTvShowList(callback: ListTvShowCallback) {
        Espresso.increment()
        handler.postDelayed({
            retrofit.listTvShow(apiKey).enqueue(object : Callback<ItemResponse> {
                override fun onResponse(
                    call: Call<ItemResponse>,
                    response: Response<ItemResponse>,
                ) {
                    val final = response.body()?.result
                    callback.onResponse(final!!)
                    Espresso.decrement()
                }

                override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }

            })
        }, TIME)
    }

    fun getDetailTv(id: Int, callback: TvShowDetailCallback) {
        Espresso.increment()
        handler.postDelayed({
            retrofit.detailTvShow(id, apiKey).enqueue(object : Callback<DataItem> {
                override fun onResponse(call: Call<DataItem>, response: Response<DataItem>) {
                    response.body()?.let { callback.onResponse(it) }
                    Espresso.decrement()
                }

                override fun onFailure(call: Call<DataItem>, t: Throwable) {
                    Log.d(TAG, t.printStackTrace().toString())
                }

            })
        }, TIME)
    }

}