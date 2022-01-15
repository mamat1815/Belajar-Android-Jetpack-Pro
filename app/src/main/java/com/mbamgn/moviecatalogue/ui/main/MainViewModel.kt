package com.mbamgn.moviecatalogue.ui.main

import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.utils.DataDummy

class MainViewModel : ViewModel() {

    private val random = (0..10).random()
    private val dummy = DataDummy.generateDummyMovie()[random]

    fun getRandomMovie() = dummy

}