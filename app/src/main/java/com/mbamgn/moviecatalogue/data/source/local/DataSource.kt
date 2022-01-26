package com.mbamgn.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import com.mbamgn.moviecatalogue.data.source.DataItem

interface DataSource {

    fun getMovie(): LiveData<List<DataItem>>
    fun getDetailData(id: Int, type: String): LiveData<DataItem>
    fun getTvShow(): LiveData<List<DataItem>>

}