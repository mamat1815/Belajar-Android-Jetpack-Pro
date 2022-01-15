package com.mbamgn.moviecatalogue.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class MovieEntity(
    var movieId: String,
    var title: String,
    var img: Int,
    var tag: String,
    var percentage: Float,
    var desc: String,
    var genre: String,
    var duration: String,
) : Parcelable