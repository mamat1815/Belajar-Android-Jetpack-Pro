package com.mbamgn.moviecatalogue.data.retrofit

import com.mbamgn.moviecatalogue.model.DataItem
import com.mbamgn.moviecatalogue.model.ItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("/3/movie/popular")
    fun listMovie(@Query("api_key") apiKey: String): Call<ItemResponse>

    @GET("/3/movie/{movie_id}")
    fun detailMovie(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String,
    ): Call<DataItem>

    @GET("/3/tv/popular")
    fun listTvShow(@Query("api_key") apiKey: String): Call<ItemResponse>

    @GET("/3/tv/{tv_id}")
    fun detailTvShow(
        @Path("tv_id") id: Int,
        @Query("api_key") apiKey: String,
    ): Call<DataItem>


}