package com.mbamgn.moviecatalogue.data.source

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import com.mbamgn.moviecatalogue.model.DataItem

interface DataSource {

    fun getMovie(): LiveData<List<DataItem>>
    fun getDetailMovie(id: Int): LiveData<DataItem>
    fun getTvShow(): LiveData<List<DataItem>>
    fun getDetailTv(id: Int): LiveData<DataItem>

}