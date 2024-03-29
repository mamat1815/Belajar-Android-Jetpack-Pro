package com.mbamgn.moviecatalogue.ui.tv_show

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.data.source.local.DataRepository
import com.mbamgn.moviecatalogue.data.source.DataItem

class TvShowFragmentViewModel(private val repository: DataRepository) : ViewModel() {

    fun getListTvShow(): LiveData<List<DataItem>> = repository.getTvShow()

    fun getLoad(): LiveData<Boolean> = repository.onLoading

}