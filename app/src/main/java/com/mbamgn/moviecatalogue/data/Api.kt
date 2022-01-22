package com.mbamgn.moviecatalogue.data

import com.mbamgn.moviecatalogue.model.DataItem
import com.mbamgn.moviecatalogue.model.ItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("/3/movie/popular")
    fun listMovie(@Query("api_key") apiKey: String): Call<ItemResponse>

    @GET("/3/movie")
    fun detailMovie(
        @Query("api_key") apiKey: String,
        @Path("id") id: Int
    ): Call<DataItem>

    @GET("/3/tv/popular")
    fun listTvShow(@Query("api_key") apiKey: String): Call<ItemResponse>
}