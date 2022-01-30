package com.mbamgn.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.data.source.DataItem
import com.mbamgn.moviecatalogue.data.source.local.DataRepository

class MovieFragmentViewModel(private val repository: DataRepository) : ViewModel() {

    fun getListMovie(): LiveData<List<DataItem>> = repository.getMovie()

    fun getLoad(): LiveData<Boolean> = repository.onLoading

}