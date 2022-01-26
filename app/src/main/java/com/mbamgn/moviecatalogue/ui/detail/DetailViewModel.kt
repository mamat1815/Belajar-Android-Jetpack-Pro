package com.mbamgn.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.data.source.local.DataRepository

class DetailViewModel(private val repository: DataRepository) : ViewModel() {

    fun getDetailMovie(type: String, id: Int) = repository.getDetailData(id, type)

}