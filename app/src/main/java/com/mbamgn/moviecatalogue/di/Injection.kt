package com.mbamgn.moviecatalogue.di

import com.mbamgn.moviecatalogue.data.retrofit.Client
import com.mbamgn.moviecatalogue.data.source.local.DataRepository
import com.mbamgn.moviecatalogue.data.source.remote.RemoteDataSource

object Injection {

    fun dataRepository(): DataRepository {
        val repository = RemoteDataSource.getInstance(Client.create())
        return repository?.let { DataRepository.getInstance(it) }!!
    }


}