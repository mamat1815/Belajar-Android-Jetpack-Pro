package com.mbamgn.moviecatalogue.data

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Client {

    private const val BASE_URL = "https://api.themoviedb.org"

    private fun client(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor{
                val original = it.request()
                val requestBuilder = original.newBuilder()
                val request = requestBuilder.build()
                it.proceed(request)
            }
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()

    fun create(): Api =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)

}