package com.mbamgn.moviecatalogue.ui.detail_tv_show

import androidx.lifecycle.ViewModel
import com.mbamgn.moviecatalogue.data.TvShowEntity
import com.mbamgn.moviecatalogue.utils.DataDummy

class DetailTvShowViewModel : ViewModel() {

    private lateinit var tvShowId: String

    fun setDetailTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getDetailTvShow(): TvShowEntity? {
        var tvShow: TvShowEntity? = null
        for (tvShowEntity in DataDummy.generateDummyTvShows()) {
            if (tvShowEntity.tvShowId == tvShowId) {
                tvShow = tvShowEntity
            }
        }
        return tvShow


    }

}