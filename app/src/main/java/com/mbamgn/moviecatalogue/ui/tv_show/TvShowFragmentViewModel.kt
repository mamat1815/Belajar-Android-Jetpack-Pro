package com.mbamgn.moviecatalogue.ui.tv_show

import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.data.TvShowEntity
import com.mbamgn.moviecatalogue.utils.DataDummy

class TvShowFragmentViewModel : ViewModel() {

    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShows()

}